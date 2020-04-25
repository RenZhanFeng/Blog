<template>
  <div class="manager">
    <nav-menu></nav-menu>
    <router-view />
  </div>
</template>

<script>

export default {
  name: "Manager",
  components: {
    NavMenu
  }
};
</script>

<style scoped>
</style>