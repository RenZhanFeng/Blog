<template>
  <div class="blogEditor">
    <!-- <el-row>
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">内容管理</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">文章管理</el-breadcrumb-item>
        <el-breadcrumb-item>编辑器</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>-->

    <el-row class="inputTitle">
      <el-input v-model="article.articleTitle" placeholder="请输入标题"></el-input>
    </el-row>
    <el-row>
      <mavon-editor
        class="mavonEditor"
        v-model="article.articleContentMd"
        @save="saveArticles"
        fontSize="16px"
      >
        <button
          type="button"
          class="op-icon el-icon-document"
          :title="'摘要/封面'"
          slot="left-toolbar-after"
          @click="dialogVisible = true"
        ></button>
      </mavon-editor>
      <el-dialog :visible="dialogVisible" @close="dialogVisible = false">
        <el-divider content-position="left">摘要</el-divider>
        <el-input
          type="textarea"
          v-model="article.articleAbstract"
          rows="6"
          maxlength="255"
          show-word-limit
        ></el-input>
        <el-divider content-position="left">封面</el-divider>
        <div class="cover">
          <el-input v-model="article.articleCover" placeholder="图片 URL"></el-input>
          <img-upload class="img-upload" @onUpload="uploadImg" ref="imgUpload"></img-upload>
        </div>
        <div slot="footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
        </div>
      </el-dialog>
    </el-row>
  </div>
</template>

<script>
import ImgUpload from "Fcomponents/Library/common/ImgUpload";
export default {
  name: "blogEditor",
  components: { ImgUpload },
  data() {
    return {
      dialogVisible: false,
      article: {
        articleTitle: "",
        articleContentMd: "",
        articleAbstract: "",
        articleCover: "",
        articleDate: ""
      }
    };
  },
  mounted() {
    console.log(this.$route);
    if (this.$route.params.article) {
      this.article = this.$route.params.article;
    }
  },
  methods: {
    //保存文章
    saveArticles(value, render) {
      // value 是 md格式，render 是 html格式
      this.$confirm("是否保存并发布文章", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$axios.post("admin/content/article", {
            id: this.article.id,
            articleTitle: this.article.articleTitle,
            articleContentMd: value,
            articleContentHtml: render,
            articleAbstract: this.article.articleAbstract,
            articleCover: this.article.articleCover,
            articleDate: this.formatDate(new Date())
          });
        })
        .catch(reject => {
          console.log(reject);
        });
    },
    //上传图片成功就修改article的数据
    uploadImg(response) {
      this.article.articleCover = response;
    },
    //格式化日期对象
    formatDate(date) {
      let year = date.getFullYear();
      let month = date.getMonth() + 1;
      let day = date.getDate();
      let hours = date.getHours();
      let minutes = date.getMinutes();
      let seconds = date.getSeconds();
      month = month < 10 ? `0${month}` : month;
      day = day < 10 ? `0${day}` : day;
      hours = hours < 10 ? `0${hours}` : hours;
      minutes = minutes < 10 ? `0${minutes}` : minutes;
      seconds = seconds < 10 ? `0${seconds}` : seconds;
      let newDate = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
      return newDate;
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.mavonEditor {
  height: calc(100vh - 160px);
}

.inputTitle {
  margin: 10px 0px;
  font-size: 18px;
  Shadow();
}

.img-upload {
  margin: 10px 0;
}
</style>