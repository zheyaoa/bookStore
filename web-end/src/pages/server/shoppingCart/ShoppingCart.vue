<template>
    <div class="container">
        <cart-header></cart-header>
        <cart-list :list=list  ></cart-list>
    </div>
</template>
<script>
import CartHeader from './components/Header';
import CartList from './components/List';
export default {
    name:'ShoppingCart',
    components:{
        CartHeader,
        CartList,
    },
    data(){
        return{
            list:[]
        }
    },
    methods:{
        getShoppingCartList(){
            this.axios.post('https://www.easy-mock.com/mock/5c03b2ae125d962d127404d1/getShoppingCart')
            .then(rs => {
                console.log(rs.data.list)
                let list = [];
                rs.data.list.forEach(item => {
                    item.num = 1;
                    item.checked = false;
                    list.push(item);
                })
                this.list = list;
            })
        },
        updateList(){

        }
    },
    activated(){
        this.updateList();
    },
    deactivated(){
            let data = JSON.stringify({list:this.list});
        this.axios.post('api/updateShoppingCart',data);
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
</style>
