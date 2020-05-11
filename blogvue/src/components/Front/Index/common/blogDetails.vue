<template>
  <div class="articles-area">
    <el-card>
      <div>
        <el-breadcrumb separator="/" class="breadcrumb" v-if="article.category">
          <el-breadcrumb-item :to="{ path: '/index' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/index' }">{{article.category.name}}</el-breadcrumb-item>
          <el-breadcrumb-item v-if="!article.category">未分类</el-breadcrumb-item>
          <el-breadcrumb-item class="breadcrumbArticleTitle">{{article.articleTitle}}</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb separator="/" class="breadcrumb" v-if="!article.category">
          <el-breadcrumb-item :to="{ path: '/index' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>未分类</el-breadcrumb-item>
          <el-breadcrumb-item class="breadcrumbArticleTitle">{{article.articleTitle}}</el-breadcrumb-item>
        </el-breadcrumb>
        <div class="articleTitle">{{article.articleTitle}}</div>
        <div class="list-meta" v-if="article.category">
          <span>
            <i class="el-icon-folder"></i>
            {{article.category.name}}
          </span>
          <span>
            <i class="el-icon-date"></i>
            {{article.articleDate}}
          </span>
          <span>
            <i class="el-icon-s-custom"></i> 1230人
          </span>
        </div>
        <div class="markdown-body">
          <img :src="article.articleCover" alt="cover" />
          <div v-html="article.articleContentHtml"></div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "blogDetails",
  data() {
    return {
      article: []
    };
  },
  mounted() {
    this.loadArticle();
  },
  methods: {
    loadArticle() {
      this.$axios.get(`/article/${this.$route.params.id}`).then(resolve => {
        if (resolve.data.code === 200) {
          this.article = resolve.data.data;
          console.log(this.article);
        }
      });
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';
@import '~common/markdown/markdown.css';

.breadcrumb {
  padding: 8px;
  border-bottom: 1px solid #eee;
  margin-bottom: 20px;
  background: #e3f1ff;
  border-radius: 4px;
  font-size: 12px;
}

.breadcrumbArticleTitle {
  width: 60%;
  no-wrap();
}

.articleTitle {
  font-size: 20px;
  text-align: center;
  color: #000000a6;
  font-weight: 600;
  margin: 15px 0;
}

.list-meta {
  padding-top: 10px;
  padding-bottom: 10px;
  color: #ccc;
  font-size: 13px;
  margin-bottom: 15px;
}

.list-meta span {
  padding-left: 10px;
  padding-right: 10px;
}
</style>
