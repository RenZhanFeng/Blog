<template>
  <el-row class="index">
    <el-col class="userInof card" :xs="24" :sm="4" :md="4" :lg="4">
      <user-info></user-info>
    </el-col>
    <el-col class="blogList card" :xs="24" :sm="16" :md="14" :lg="11">
      <blog-list></blog-list>
    </el-col>
    <el-col class="blogCategory card" :xs="24" :sm="4" :md="4" :lg="3">
      <el-row>
        <el-col :span="24" class="item">这里是分类</el-col>
      </el-row>
    </el-col>
  </el-row>
</template>

<script>
import BlogList from "Fcomponents/Index/common/blogList";
import UserInfo from "Fcomponents/Index/common/userInfo";
export default {
  name: "Index",
  components: { BlogList, UserInfo },
  data() {
    return {};
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.index {
  margin-top: 40px;
}

.card {
  margin-left: 10px;
  margin-right: 10px;
}

.item {
  margin-bottom: 20px;
  padding: 20px;
  Shadow();
}
</style>
