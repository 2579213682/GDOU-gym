<template>
  <div class="container">
    <canvas id="draw"  style="position: fixed; width: 100vw; height: 100vh; z-index: 0; display: block">
      当前浏览器不支持Canvas，请更换浏览器后再试
    </canvas>
    <el-row type="flex" class="row-bg" justify="center">
<!--      <el-col :xl="6" :lg="7">-->
<!--        <div id="top">-->
<!--&lt;!&ndash;          <el-image style="vertical-align: middle;" :src="require('@/assets/top.png')"></el-image>&ndash;&gt;-->
<!--        -->
<!--        </div>-->
<!--        <el-image style="padding-bottom: 20px;" :src="require('@/assets/login.png')"></el-image>-->
<!--      </el-col>-->
<!--      <el-col :span="1">-->
<!--        <el-divider direction="vertical"></el-divider>-->
<!--      </el-col>-->
      <el-col :xl="6" :lg="7">
        <el-image :src="require('@/assets/Gdou.png')" style="width: 100px; height: 100px;"></el-image>
        <p style="font-size: 20px; font-weight: 500;     color: blue;
  background-image:-webkit-linear-gradient(top,#0d388c, #2462db,#7196e0);
    -webkit-background-clip:text;
    -webkit-text-fill-color:transparent; ">广东海洋大学教务系统登录系统</p>
        <el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="80px">
          <el-form-item label="用户名" prop="username" style="width:380px;font-weight: 800;color: #333333">
            <el-input v-model="loginForm.username" style="" class="inputbgc"></el-input>
          </el-form-item>
          <el-form-item label="密 码" prop="password" style="width: 380px;font-weight: 800;color: #333333">
            <el-input v-model="loginForm.password" type="password" class="inputbgc"></el-input>
          </el-form-item>
          <el-form-item label="验证码" prop="code" style="width: 380px;font-weight: 800;color: #333333;">
            <el-input v-model="loginForm.code" style="width: 172px; float: left;" class="inputbgc"></el-input>
            <el-image :src="captchaImg" class="captchaImg" @click="getCaptcha"></el-image>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('loginForm')" style="opacity: 0.9;">登录</el-button>
            <el-button @click="resetForm('loginForm')" style="opacity: 0.9">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import qs from 'qs';
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
        code: '',
        key: '',
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ],
        code: [
          { required: true, message: '请输入验证码', trigger: 'blur' },
          { min: 5, max: 5, message: '长度为 5 个字符', trigger: 'blur' }
        ]
      },
      captchaImg: null
    };
  },
  created() {
    this.getCaptcha();
  },
  mounted() {
    this.draw();
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post('/login?' + qs.stringify(this.loginForm)).then(res => {
            const jwt = res.headers['authorization'];
            this.$store.commit('SET_TOKEN',jwt);
            this.$router.push("/index");
          }).catch(res => {
            this.getCaptcha();
          })
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    getCaptcha(){
      this.$axios.get('/captcha').then(res => {
        this.loginForm.key = res.data.data.key;
        this.captchaImg = res.data.data.captchaImg;
        this.loginForm.code = '';
      })
    }
  }
}
</script>

<style scoped>
.container{
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
    background-image: url("../assets/Loginbgc.jpg");
    background-position: center;
}
.el-row{
  /*background-color: #f1f2f6;*/
  display: flex;
  align-items: center;
  text-align: center;
    width: 450px;

}

.el-row .el-col:nth-child(1){
  flex: 45%;
}
.el-row .el-col:nth-child(2){
  flex: 10%;
}
.el-row .el-col:nth-child(3){
  flex: 45%;
  margin-left: -20px;
}

.el-divider{
  height: 380px;
}
.captchaImg{
  float: left;
  margin-left: 8px;
  border-radius: 4px;
}
#top{
  padding-bottom: 20px;
  text-align: left;
}
#top span{
  font-size: 20px;
  color: rgb(2, 167, 240);
}
.inputbgc{
    background-color: transparent;
    opacity: 0.78;
    color: #333333;
}

</style>
