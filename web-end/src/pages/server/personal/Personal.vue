<template>
    <div class="container">
        <personal-header></personal-header>
        <personal-nav></personal-nav>
    </div>
</template>
<script>
import PersonalHeader from './components/Header'
import PersonalNav from './components/Nav'
export default {
    name:'Personal',
    components:{
        PersonalHeader,
        PersonalNav
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
        background #ebeced
</style>
