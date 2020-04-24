<template>
  <div>
    <el-upload
      class="img-upload"
      ref="upload"
      :action="action"
      :before-remove="beforeRemove"
      :on-success="handleSuccess"
      multiple
      :limit="1"
      :on-exceed="handleExceed"
      :file-list="fileList"
    >
      <el-button size="small" type="primary">点击上传</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
    </el-upload>
  </div>
</template>

<script>
export default {
  name: "ImgUpload",
  data() {
    return {
      fileList: [],
      url: "",
      action: "http://localhost:8443/api/covers"
    };
  },
  methods: {
    //上传文件超出一个的时候弹框提醒
    handleExceed() {
      this.$message.warning(`当前限制选择 1 个文件`);
    },
    //删除文件的时候弹框提醒
    beforeRemove(file) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
    //上传成功
    handleSuccess(response) {
      this.$emit("onUpload", response);
      this.$message.warning("上传成功");
      this.clear()
    },
    //清除文件
    clear() {
      this.$refs.upload.clearFiles();
    }
  }
};
</script>