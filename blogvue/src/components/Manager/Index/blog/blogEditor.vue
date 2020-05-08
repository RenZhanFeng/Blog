<template>
  <div class="blogEditor">
    <el-row>
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>内容管理</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/manager/index/blogManagement'}">博客内容管理</el-breadcrumb-item>
        <el-breadcrumb-item>文章编辑</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
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
      <el-button type="danger" class="commitBtn" @click="saveArticles">提交上传（暂时还是得 CTRL + S 提交）</el-button>
      <el-dialog :visible="dialogVisible" @close="dialogVisible = false">
        <el-divider content-position="left">摘要</el-divider>
        <el-input
          type="textarea"
          v-model="article.articleAbstract"
          rows="6"
          maxlength="255"
          show-word-limit
        ></el-input>
        <el-divider content-position="left">分类</el-divider>
        <el-select v-model="article.category" value-key="id" placeholder="请选择分类">
          <el-option
            v-for="(item, index) in categories"
            :key="index"
            :value="{'id':item.id,'name':item.name}"
            :label="item.name"
          ></el-option>
        </el-select>
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
import { formatDate } from "common/js/util";
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
        articleDate: "",
        category: {}
      },
      categories: []
    };
  },
  mounted() {
    //在‘博客内容管理’页面点击编辑会传递article过来
    if (this.$route.params.article) {
      this.article = this.$route.params.article;
    }
    this.getCategoryList();
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
          this.$axios
            .post("admin/content/article", {
              id: this.article.id,
              articleTitle: this.article.articleTitle,
              articleContentMd: value,
              articleContentHtml: render,
              articleAbstract: this.article.articleAbstract,
              articleCover: this.article.articleCover,
              articleDate: formatDate(new Date()),
              category: this.article.category
            })
            .then(res => {
              if (res.status === 200) {
                this.$message({ type: "success", message: "提交成功" });
              }
            })
            .catch(() => {
              this.$message({ type: "error", message: "一定要选分类和写标题" });
            });
        })
        .catch(() => {
          this.$message({ type: "info", message: "已取消" });
        });
    },
    //上传图片成功就修改article的数据
    uploadImg(response) {
      this.article.articleCover = response;
    },
    //获取分类数据
    getCategoryList() {
      this.$axios.get("/categories").then(resolve => {
        if (resolve.data.code === 200) {
          this.categories = resolve.data.data;
          console.log(this.categories);
        }
      });
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.mavonEditor {
  height: calc(100vh - 250px);
}

.inputTitle {
  margin: 10px 0px;
  font-size: 18px;
  Shadow();
}

.img-upload, .commitBtn {
  margin: 10px 0;
}

.commitBtn {
}
</style>