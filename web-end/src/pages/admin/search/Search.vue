<template>
    <div class="container">
        <search-header></search-header>
        <search-list :list=list></search-list>
    </div>
</template>
<script>
import SearchHeader from './components/Header'
import SearchList from './components/List'
export default {
    name:'Search',
    components:{
        SearchHeader,
        SearchList
    },
    data(){
        return{
            list:[
            ]
        }
    },
    mounted(){
        this.axios.post('http://localhost:8080/api/getUserList')
        .then(rs => {
            this.list = rs.data
        })
    }
}
</script>
<style lang="stylus" scoped>

</style>
