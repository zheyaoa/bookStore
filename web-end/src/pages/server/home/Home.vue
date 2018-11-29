<template>
    <div class="container">
        <server-head></server-head>
        <book-type></book-type>
        <book-list></book-list>
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
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
</style>
