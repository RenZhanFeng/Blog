<template>
  <div class="articles-area">{{article}}</div>
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
      this.$axios.get(`/article/${this.$route.query}`).then(resolve => {
        if (resolve.data.code === 200) {
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
