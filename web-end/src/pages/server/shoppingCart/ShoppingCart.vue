<template>
    <div class="container">
        <cart-header></cart-header>
        <cart-list :list=list  @updateList="handleUpdateList"></cart-list>
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
    watch:{
        list(){
            this.updateShoppingCartList();
        }
    },
    methods:{
        getShoppingCartList(){
            this.axios.post('http://localhost:8080/api/getShoppingCart')
            .then(rs => {
                console.log(rs);
                let list = [];
                rs.data.forEach(item => {
                    item.num = 1;
                    item.checked = false;
                    list.push(item);
                })
                this.list = list;
            })
        },
        updateShoppingCartList(){
            let data = JSON.stringify({list:this.list});
            this.axios.post('http://localhost:8080/api/updateShoppingCartList',data);
        },
        handleUpdateList(list){
            this.list = list;
        }
    },
    activated(){
        this.getShoppingCartList();
    },
    deactivated(){
        this.updateShoppingCartList()
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
</style>
