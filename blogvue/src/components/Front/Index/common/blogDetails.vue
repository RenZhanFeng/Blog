<template>
  <div class="articles-area">
    <el-card style="text-align: left;">
      <div>
        <span style="font-size: 20px">
          <strong>{{article.articleTitle}}</strong>
        </span>
        <el-divider content-position="left">{{article.articleDate}}</el-divider>
        <div class="markdown-body">
          <img :src="article.articleCover" alt="">
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
      console.log(this.$route)
      this.$axios.get(`/article/${this.$route.params.id}`).then(resolve => {
        if (resolve.data.code === 200) {
          console.log(resolve)
          this.article = resolve.data.data;
        }
      });
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';
@import '~common/markdown/markdown.css';
</style>
