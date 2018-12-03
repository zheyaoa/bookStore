<template>
  <div id="app">
    <keep-alive>
      <router-view > </router-view>   
    </keep-alive>    
  </div>
</template>
<script>
import Home from 'server/home/Home';
export default {
  
}
</script>

<style lang="stylus">
  html,body,#app 
    height 100%
</style>
