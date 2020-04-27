<template>
  <div>
    <!-- <el-row>
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">内容管理</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">文章管理</el-breadcrumb-item>
        <el-breadcrumb-item>编辑器</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row>
      <el-input class="inputTitle" v-model="article.articleTitle" placeholder="请输入标题"></el-input>
    </el-row>-->

    <mavon-editor
      :toolbars="markdownOption"
      v-model="article.articleContentMd"
      @save="saveArticles"
      fontSize="16px"
    ></mavon-editor>

  </div>
</template>

<script>
export default {
  name: "Editor",
  data() {
    return {
      article: [
        {
          articleTitle: "",
          articleContentMd: ""
        }
      ]
    };
  },
  methods: {
    //保存文章
    saveArticles() {}
  }
};
</script>

<style scoped>
.inputTitle {
  margin: 10px 0px;
  font-size: 18px;
}
</style>