<template>
  <div>
    <el-row>
      <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
        <el-breadcrumb-item :to="{ path: '/manager/index' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>分类管理</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row>
      <el-button type="success" class="add-link" @click="dialogVisible = true">添加分类</el-button>
      <el-card>
        <el-table :data="categories" ref="multipleTable" @selection-change="handleSelectionChange">
          <el-table-column type="selection"></el-table-column>
          <el-table-column label="分类名" prop="name"></el-table-column>
          <el-table-column label="排序" prop="sort"></el-table-column>
          <el-table-column label="添加日期" prop="create" sortable></el-table-column>
          <el-table-column label="修改日期" prop="update" sortable></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="text" size="small" @click.prevent="editCategory(scope.row)">编辑</el-button>
              <el-button type="text" size="small" @click.prevent="deleteCategory(scope.row.id)">移除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="btn">
          <el-button @click.prevent="toggleSelection()" v-show="multiDeleteVisible">取消选择</el-button>
          <el-button
            type="warning"
            @click.prevent="deleteAllCategory()"
            v-show="multiDeleteVisible"
          >批量删除</el-button>
        </div>
      </el-card>

      <el-dialog :visible="dialogVisible" @close="clear">
        <el-divider content-position="left">分类名</el-divider>
        <el-input v-model="category.name"></el-input>
        <el-divider content-position="left">排序</el-divider>
        <el-input v-model="category.sort"></el-input>
        <div slot="footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="Confirm">确 定</el-button>
        </div>
      </el-dialog>

      <el-pagination
        class="pagination"
        background
        @current-change="handleCurrentChange"
        :hide-on-single-page="true"
        :page-size="pageSize"
        :total="total"
      ></el-pagination>
    </el-row>
  </div>
</template>

<script>
import { formatDate } from "common/js/util";
export default {
  name: "blogManagement",
  data() {
    return {
      articles: [],
      categories: [],
      category: {
        name: "",
        sort: "",
        creat: "",
        update: ""
      },
      dialogVisible: false,
      pageSize: 10,
      total: null,
      multiDeleteVisible: false,
      multipleSelection: [] //勾选中的文章数据
    };
  },
  mounted() {
    this.getCategoryList();
  },
  methods: {
    //获取分类数据
    getCategoryList() {
      this.$axios.get("/categories").then(resolve => {
        if (resolve.data.code === 200) {
          this.categories = resolve.data.data;
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
    //打开编辑分类对话框
    editCategory(categoryItem) {
      this.dialogVisible = true;
      this.category = categoryItem;
    },
    //确认修改或添加分类
    Confirm() {
      this.$confirm("是否保存分类", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$axios
          .post("/categories", {
            id: this.category.id,
            name: this.category.name,
            sort: this.category.sort,
            create: this.category.create || formatDate(new Date()),
            update: formatDate(new Date())
          })
          .then(res => {
            if (res.status === 200) {
              this.dialogVisible = false;
              this.$message({ type: "success", message: "添加或修改成功" });
              this.getCategoryList();
            }
          })
          .catch(reject => {
            this.$message({ type: "error", message: reject });
          });
      });
    },
    //关闭表单时清除表单内容
    clear() {
      this.dialogVisible = false;
      this.category = {
        id: "",
        name: "",
        sort: "",
        creat: "",
        update: ""
      };
    },
    //删除分类
    deleteCategory(id) {
      this.$confirm("此操作将永久删除该分类, 是否继续?", "询问", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      })
        .then(() => {
          this.$axios.post(`/categories/delete/`, { id: id }).then(resp => {
            if (resp && resp.status === 200) {
              this.getCategoryList();
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
    //批量删除分类
    deleteAllCategory() {
      this.$confirm("此操作将永久删除所选中分类, 是否继续?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      })
        .then(() => {
          this.multipleSelection.forEach(item => {
            this.$axios.post(`/categories/delete/`, { id: item.id }).then(resp => {
              if (resp && resp.status === 200) {
                this.getCategoryList();
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