<template>
  <el-row>
    <el-col :span="24" class="item" v-for="(item,index) in articles" :key="index">
      <div class="list-Content">
        <div class="list-title">
          <a href="javascript:" @click="goDetails(item)">{{item.articleTitle}}</a>
        </div>
        <div class="list-meta">
          <span>
            <i class="el-icon-folder"></i> 分类名字
          </span>
          <span>
            <i class="el-icon-date"></i>
            {{item.articleDate}}
          </span>
          <span>
            <i class="el-icon-s-custom"></i> 1230人
          </span>
        </div>
        <div class="list-cover">
          <img :src="item.articleCover" alt="cover" v-if="item.articleCover" />
        </div>
        <div class="list-abstract">
          <p>{{item.articleAbstract}}</p>
        </div>
      </div>
      <div class="list-go">
        <i class="el-icon-document"></i>
        <span>
          <a href="javascript:" @click="goDetails(item)">
            查看详情
            <i class="el-icon-arrow-right"></i>
          </a>
        </span>
      </div>
    </el-col>
    <el-col>
      <el-pagination
        background
        layout="total, prev, pager, next, jumper"
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :total="total"
      ></el-pagination>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "blogList",
  data() {
    return {
      articles: [],
      pageSize: 10,
      total: null
    };
  },
  mounted() {
    this.loadArticles();
  },
  methods: {
    //初次进入页面加载第一页文章数据
    loadArticles() {
      this.$axios
        .get(`/articles?page=1&size=${this.pageSize}`)
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.articles = resolve.data.data.content;
            this.total = resolve.data.data.totalElements;
            this.$store.commit(
              "getpostsTotal",
              resolve.data.data.totalElements
            );
          }
        });
    },
    //currentPage 改变时会触发
    handleCurrentChange(page) {
      this.$axios
        .get(`/articles?page=${page}&size=${this.pageSize}`)
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.articles = resolve.data.data.content;
          }
        });
    },
    //点击查看详情跳转页面
    goDetails(item) {
      this.$router.push({
        name: "blogDetails",
        params: { id: item.id }
      });
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.item {
  margin-bottom: 20px;
  padding: 20px;
  Shadow();
}

// 这是el-pagination标签自带的class
.el-pagination {
  text-align: center;
}

.list-title a {
  color: #000;
  font-size: 20px;
}

.list-title a:hover {
  color: #1e90ff;
}

.list-meta {
  padding-top: 10px;
  padding-bottom: 10px;
  color: #ccc;
  font-size: 13px;
}

.list-meta span {
  padding-left: 10px;
  padding-right: 10px;
}

.list-cover img {
  width: 100%;
  display: block;
  margin: 8px auto;
  object-fit: cover;
  Shadow();
}

.list-abstract {
  font-size: 15px;
  color: #999;
  line-height: 20px;
}

.list-go {
  text-align: right;
  font-size: 12px;
}

.list-go a {
  color: #1890ff;
}

.list-go a:hover {
  color: #40a9ff;
}
</style>
