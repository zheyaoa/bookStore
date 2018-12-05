<template>
    <div class="container">
        <server-head></server-head>
        <book-type @handleTagClick=getCommodityListByTypeId></book-type>
        <book-list :list=list></book-list>
        <server-footer></server-footer>
    </div>
</template>
<script>
import ServerHead from './components/Header.vue'
import BookType from './components/Type.vue'
import BookList from './components/List.vue'
import ServerFooter from '@/components/Footer'
export default {
    name:'Home',
    components:{
        ServerHead,
        BookType,
        BookList,
        ServerFooter
    },
    data(){
        return{
            list:[
            ]
        }
    },
    mounted(){
        this.getCommodityListByTypeId(0);
    },
    methods:{
        getCommodityListByTypeId(typeId){
            let data = {typeId};
            data = JSON.stringify(data);
            this.axios.post('http://localhost:8080/api/getCommodityListByTypeId',data)
            .then(rs => {
                this.list = rs.data
            })
        }
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
</style>
