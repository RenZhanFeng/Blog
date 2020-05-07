<template>
  <div class="front">
    <nav-menu></nav-menu>
    <router-view />
    <el-row class="footer">这里是啥也没有的底部</el-row>
  </div>
</template>

<script>
import NavMenu from "Fcomponents/NavBar/NavMenu";
export default {
  name: "Front",
  components: {
    NavMenu
  }
};
</script>

<style scoped lang='stylus'>
.footer {
  width: 100%;
  height: 20vh;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
  border-top: solid 1px #e6e6e6;
  padding:20px
  text-align: center;
}
</style>