<template>
    <div class="container">
        <admin-header></admin-header>
        <admin-menu></admin-menu>
    </div>
</template>
<script>
import AdminHeader from './components/Header';
import AdminMenu from './components/Menu';
export default {
    name:'Admin',
    components:{
        AdminHeader,
        AdminMenu
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
        background #ebeced
</style>
