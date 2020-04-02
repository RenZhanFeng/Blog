<template>
  <nav class="_navbar navbar-fixed-top">
    <div class="container">
      <div class="row">
        <div class="col-xs-5 navbar-brand">
          <a class="navbar-item navbar-logo" href="/">
            <span class="user">Roger</span>
            <span class="hidden-xs">的个人博客</span>
          </a>
        </div>
        <div class="_search col-xs-7 text-right">
          <input class="box _searchBar" ref="query" placeholder="搜索" />
          <i class="iconfont icon-sousuo"></i>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";
export default {};
</script>

<style scoped lang="stylus">
@import "~stylus/variable";

._navbar {
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
}

.user {
  font-size: $font-size-large-x;
  color: $color-theme;
}

.navbar-item {
  letter-spacing: 1.2px;
  font-size: 14px;
}

.navbar-item:hover {
  opacity: 0.7;
}

._search {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding: 15px 15px;
}

._searchBar {
  border-bottom: 1px solid $color-theme;
  font-size: 12px;
  outline: none;
  line-height: 20px;
}

.icon-sousuo {
  color: $color-theme;
  margin-left: 2px;
  cursor: pointer;
}
</style>