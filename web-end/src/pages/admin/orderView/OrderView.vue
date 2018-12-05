<template>
    <div class="container">
        <view-header></view-header>
        <view-list :list=list></view-list>
        <view-tab @tabClick=getOrderList></view-tab>
    </div>
</template>
<script>
import ViewHeader from './components/Header'
import ViewList from './components/List'
import ViewTab from './components/Tab'
export default {
    name:'OrderView',
    components:{
        ViewHeader,
        ViewList,
        ViewTab
    },
    data(){
        return{
            list:[]
        }
    },
    mounted(){
        this.getOrderList(2)
    },
    methods:{
        getOrderList(id){
            let data = JSON.stringify({"status":id});
            this.axios.post('http://localhost:8080/api/getAllOrderList',data)
            .then(rs => {
                this.list = rs.data;
            })
        }
    }
}
</script>
<style lang="stylus" scoped>

</style>
