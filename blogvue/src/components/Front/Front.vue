<template>
  <div class="front">
    <nav-menu></nav-menu>
    <router-view />
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

<style scoped>
</style>