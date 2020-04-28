<template>
  <div>
    <el-col :xs="12" :sm="6" :md="6" :lg="6">
      <i class="el-icon-circle-plus-outline" @click="dialogFormVisible = true"></i>
    </el-col>

    <el-dialog title="添加/修改图书" :visible.sync="dialogFormVisible" @close="clear">
      <el-form :model="form" label-position="right" label-width="80px">
        <el-form-item label="书名" prop="title">
          <el-input v-model="form.title" autocomplete="off" placeholder="不加《》"></el-input>
        </el-form-item>
        <el-form-item label="作者" prop="author">
          <el-input v-model="form.author"></el-input>
        </el-form-item>
        <el-form-item label="出版日期" prop="date">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.date"></el-date-picker>
        </el-form-item>
        <el-form-item label="出版社" prop="press">
          <el-input v-model="form.press"></el-input>
        </el-form-item>
        <el-form-item label="封面" prop="cover">
          <el-input v-model="form.cover" placeholder="图片 URL"></el-input>
          <img-upload @on-success="uploadImg" ref="imgUpload"></img-upload>
        </el-form-item>

        <el-form-item label="简介" prop="abs">
          <el-input type="textarea" v-model="form.abs"></el-input>
        </el-form-item>
        <el-form-item label="分类" prop="cid">
          <el-select v-model="form.category" value-key="id" placeholder="请选择分类" ref="select">
            <el-option
              v-for="(item,index) in categories"
              :key="index"
              :value="{'id':item.id,'name':item.name}"
              :label="item.name"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="onSubmit">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { mapState } from "vuex";
import ImgUpload from "Fcomponents/Library/common/ImgUpload";
export default {
  name: "EditForm",
  data() {
    return {
      dialogFormVisible: false,
      form: {
        id: "",
        title: "",
        author: "",
        date: "",
        press: "",
        cover: "",
        abs: "",
        category: {
          id: "",
          name: ""
        }
      }
    };
  },
  components: { ImgUpload },
  computed: {
    ...mapState(["categories"])
  },
  methods: {
    //关闭表单时清除表单内容
    clear() {
      this.form = {
        id: "",
        title: "",
        author: "",
        date: "",
        press: "",
        cover: "",
        abs: "",
        category: ""
      };
    },
    //点击确定提交表单
    onSubmit() {
      this.$axios
        .post("/books", {
          id: this.form.id,
          cover: this.form.cover,
          title: this.form.title,
          author: this.form.author,
          date: this.form.date,
          press: this.form.press,
          abs: this.form.abs,
          category: this.form.category
        })
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.dialogFormVisible = false;
            this.$emit("onSubmit");
          }
        })
        .catch(reject => {
          console.log(reject);
        });
    },
    //上传图片成功就修改form的数据
    uploadImg(response) {
      this.form.cover = response;
    }
  }
};
</script>

<style scoped>
.el-icon-circle-plus-outline {
  position: absolute;
  right: 0;
  top: 10px;
  font-size: 30px;
  cursor: pointer;
  color: #409eff;
}
.dialog-footer {
  text-align: right;
}
</style>