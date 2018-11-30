<template>
    <div class="container">
        <search-header></search-header>
        <search-list></search-list>
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
    }
}
</script>
<style lang="stylus" scoped>

</style>
