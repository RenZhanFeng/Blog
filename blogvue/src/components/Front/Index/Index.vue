<template>
  <el-row class="index">
    <el-container>
      <el-col :xs="0" :sm="1" :md="1" :lg="3"></el-col>
      <el-col class="userInof card" :xs="0" :sm="5" :md="5" :lg="5">
        <el-row>
          <el-col :span="24" class="item">qwe</el-col>
        </el-row>
      </el-col>
      <el-col class="blogList card" :xs="24" :sm="13" :md="13" :lg="10">
        <el-row>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
        </el-row>
      </el-col>
      <el-col class="blogCategory card" :xs="0" :sm="4" :md="4" :lg="3">
        <el-row>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
        </el-row>
      </el-col>
      <el-col :xs="0" :sm="1" :md="1" :lg="3"></el-col>
    </el-container>
  </el-row>
</template>

<script>
export default {
  name: "Index",
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
