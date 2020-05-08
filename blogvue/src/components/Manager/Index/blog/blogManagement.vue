<template>
  <div>
    <el-row>
      <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
        <el-breadcrumb-item :to="{ path: '/manager/index' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>内容管理</el-breadcrumb-item>
        <el-breadcrumb-item>博客内容管理</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row>
      <el-link href="/manager/index/blogEditor" :underline="false" class="add-link">
        <el-button type="success">写文章</el-button>
      </el-link>
      <el-card>
        <el-table :data="articles" ref="multipleTable" @selection-change="handleSelectionChange">
          <el-table-column type="selection"></el-table-column>
          <el-table-column type="expand">
            <template slot-scope="props">
              <el-form label-position="left" inline>
                <el-form-item>
                  <span>{{ props.row.articleAbstract }}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column label="题目（展开查看摘要）" prop="articleTitle"></el-table-column>
          <el-table-column label="分类" prop="category.name"></el-table-column>
          <el-table-column label="发布日期" prop="articleDate" sortable></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="text" size="small" @click.prevent="viewArticle(scope.row.id)">查看</el-button>
              <el-button type="text" size="small" @click.prevent="editArticle(scope.row)">编辑</el-button>
              <el-button type="text" size="small" @click.prevent="deleteArticle(scope.row.id)">移除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="btn">
          <el-button @click.prevent="toggleSelection()" v-show="multiDeleteVisible">取消选择</el-button>
          <el-button
            type="warning"
            @click.prevent="deleteAllArticle()"
            v-show="multiDeleteVisible"
          >批量删除</el-button>
        </div>
      </el-card>
      <el-pagination
        class="pagination"
        background
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :hide-on-single-page="true"
        :total="total"
      ></el-pagination>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "blogManagement",
  data() {
    return {
      articles: [],
      pageSize: 10,
      total: null,
      multiDeleteVisible: false,
      multipleSelection: [] //勾选中的文章数据
    };
  },
  mounted() {
    this.loadArticles();
  },
  methods: {
    loadArticles() {
      this.$axios
        .get(`/articles?page=1&size=${this.pageSize}`)
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.articles = resolve.data.data.content;
            this.total = resolve.data.data.totalElements;
          }
        });
    },
    handleCurrentChange(page) {
      this.$axios
        .get(`/articles?page=${page}&size=${this.pageSize}`)
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.articles = resolve.data.data.content;
          }
        });
    },
    //查看文章
    viewArticle(id) {
      let url = this.$router.resolve({
        path: `/index/blogDetails/${id}`
      });
      console.log(url);
      window.open(url.href, "_blank");
    },
    //编辑文章
    editArticle(article) {
      console.log(this.$router);
      this.$router.push({
        name: "blogEditor",
        params: {
          article
        }
      });
    },
    //删除文章
    deleteArticle(id) {
      this.$confirm("此操作将永久删除该文章, 是否继续?", "询问", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      })
        .then(() => {
          this.$axios.get("/admin/article/" + id).then(resp => {
            if (resp && resp.status === 200) {
              this.loadArticles();
              this.$message({ type: "info", message: "删除成功" });
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    //批量删除文章
    deleteAllArticle() {
      this.$confirm("此操作将永久删除所选中文章, 是否继续?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      })
        .then(() => {
          this.multipleSelection.forEach(item => {
            this.$axios.get("/admin/article/" + item.id).then(resp => {
              if (resp && resp.status === 200) {
                this.loadArticles();
                this.$message({ type: "info", message: "删除成功" });
              }
            });
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消批量删除"
          });
        });
    },
    //勾选文章时触发
    handleSelectionChange(val) {
      this.multiDeleteVisible = true;
      this.multipleSelection = val;
      if (val.length == 0) {
        this.multiDeleteVisible = false;
      }
    },
    //取消选择
    toggleSelection() {
      this.$refs.multipleTable.clearSelection();
    }
  }
};
</script>

<style scoped lang="stylus">
@import '~stylus/variable';

.add-link, .btn, .pagination {
  margin: 15px 0;
}

.pagination {
  text-align: center;
}
</style>