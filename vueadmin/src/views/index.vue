<template>
    <div class="bgc" >

        <p>欢迎来到广东海洋大学体育管理系统</p>
    </div>


</template>

<script>

</script>

<style scoped>
.bgc {
    position: relative;
    /*bottom: 15px;*/
    right: 25px;
    width: 103%;
    height: 84vh;
    /*以下两种路径方式都可以*/
    /*background-image: url('../../../../assets/images/logo.png');*/
    background-image: url("../assets/gymbgc.jpg");
    background-size: 100% 100%;
    opacity: 0.8;
}
p{
    position: relative;
    text-align: center;
    font-size: 50px;
    margin: 0 auto;
    left: 50%;
    top:50%;
    transform: translate(-50%,-50%);
    color: #a00000;
    font-style: oblique;
    background-image:-webkit-linear-gradient(top, #f41a21,#cf5e17,#de6912);
    -webkit-background-clip:text;
    -webkit-text-fill-color:transparent;
}

</style>