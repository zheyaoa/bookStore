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
        this.axios.post('https://www.easy-mock.com/mock/5c03b2ae125d962d127404d1/getUserMessage')
        .then(rs => {
            this.list = rs.data.list
        })
    }
}
</script>
<style lang="stylus" scoped>

</style>
