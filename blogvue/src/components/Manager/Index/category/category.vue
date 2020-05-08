<template>
  <div>
    <el-row>
      <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
        <el-breadcrumb-item :to="{ path: '/manager/index' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>分类管理</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row>
      <el-button type="success" class="add-link">添加分类</el-button>
      <el-card>
        <el-table :data="articles" ref="multipleTable" @selection-change="handleSelectionChange">
          <el-table-column type="selection"></el-table-column>
          <el-table-column label="分类名" prop="articleTitle"></el-table-column>
          <el-table-column label="排序" prop="articleTitle"></el-table-column>
          <el-table-column label="添加日期" prop="articleDate" sortable></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
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
            // console.log(this.articles);
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