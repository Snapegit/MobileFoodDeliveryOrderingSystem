<template>
	<div>
		<div class="register_view">
			<el-form :model="registerForm" class="register_form">
				<div class="title_view">{{projectName}}注册</div>
				<div class="list_item">
					<div class="list_label">商家账号：</div>
					<el-input class="list_inp"
						 v-model="registerForm.shangjiazhanghao" 
						 placeholder="请输入商家账号"
						 type="text"
						/>
				</div>
				<div class="list_item">
					<div class="list_label">商家密码：</div>
					<el-input class="list_inp"
						 v-model="registerForm.shangjiamima" 
						 placeholder="请输入商家密码"
						 type="password"
						 />
				</div>
				<div class="list_item">
					<div class="list_label">确认商家密码：</div>
					<el-input class="list_inp" v-model="registerForm.shangjiamima2" type="password" placeholder="请输入确认商家密码" />
				</div>
				<div class="list_item">
					<div class="list_label">头像：</div>
					<div :style='{"width":"100%","margin":"0 0 0 10px","flex":"1"}' class="list_file_list">
						<uploads
							action="file/upload" 
							tip="请上传头像" 
							:limit="3"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''" 
							@change="touxiangUploadSuccess">
						</uploads>
					</div>
				</div>
				<div class="list_item">
					<div class="list_label">商家名称：</div>
					<el-input class="list_inp"
						 v-model="registerForm.shangjiamingcheng" 
						 placeholder="请输入商家名称"
						 type="text"
						/>
				</div>
				<div class="list_item">
					<div class="list_label">联系电话：</div>
					<el-input class="list_inp"
						 v-model="registerForm.lianxidianhua" 
						 placeholder="请输入联系电话"
						 type="text"
						/>
				</div>
				<div class="list_item">
					<div class="list_label">商家地址：</div>
					<el-input class="list_inp"
						 v-model="registerForm.shangjiadizhi" 
						 placeholder="请输入商家地址"
						 type="text"
						/>
				</div>
				<div class="list_item">
					<div class="list_label">联系人：</div>
					<el-input class="list_inp"
						 v-model="registerForm.lianxiren" 
						 placeholder="请输入联系人"
						 type="text"
						/>
				</div>
				<div class="list_btn">
					<el-button class="register" type="success" @click="handleRegister">注册</el-button>
					<div class="r-login" @click="close">已有账号，直接登录</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context?.$project.projectName
	//获取注册类型
	import { useRoute } from 'vue-router';
	const route = useRoute()
	const tableName = ref('shangjia')
	
	const registerForm = ref({
	})
	const init=()=>{
	}
    const touxiangUploadSuccess=(fileUrls)=> {
        registerForm.value.touxiang = fileUrls;
    }
	// 多级联动参数
	//注册按钮
	const handleRegister = () => {
		let url = tableName.value +"/register";
		if((!registerForm.value.shangjiazhanghao)){
			context?.$toolUtil.message(`商家账号不能为空`,'error')
			return false
		}
		if((!registerForm.value.shangjiamima)){
			context?.$toolUtil.message(`商家密码不能为空`,'error')
			return false
		}
		if(registerForm.value.touxiang!=null){
			registerForm.value.touxiang = registerForm.value.touxiang.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if((!registerForm.value.shangjiamingcheng)){
			context?.$toolUtil.message(`商家名称不能为空`,'error')
			return false
		}
		if(registerForm.value.lianxidianhua&&(!context?.$toolUtil.isPhone(registerForm.value.lianxidianhua))){
			context?.$toolUtil.message(`联系电话应输入电话格式`,'error')
			return false
		}
		
		context?.$http({
			url:url,
			method:'post',
			data:registerForm.value
		}).then(res=>{
			context?.$toolUtil.message('注册成功','success', obj=>{
				context?.$router.push({
					path: "/login"
				});
			})
		})
	}
	//公共方法
	const getUUID=()=> {
		return new Date().getTime();
	}
	//返回登录
	const close = () => {
		context?.$router.push({
			path: "/login"
		});
	}
	init()
</script>
<style lang="scss" scoped>
	
	.register_view {
		background-repeat: no-repeat;
		flex-direction: column;
		background-size: 100% 100%;
		background: url(http://clfile.zggen.cn/20231117/af5c8c517fa9421dad15d3669b128dec.jpg) no-repeat center center / cover;
		display: flex;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		position: relative;
		background-position: center center;
		// 表单盒子
		.register_form {
			border-radius: 0px;
			padding: 30px 20px;
			margin: 0 auto;
			clip-path: polygon(95% 0, 100% 5%, 100% 100%, 0% 100%, 0 5%, 5% 0);
			background: #fff;
			display: flex;
			width: 30vw;
			justify-content: flex-start;
			flex-wrap: wrap;
		}
		// 标题样式
		.title_view {
			padding: 0px;
			margin: 0 auto 20px;
			color: #6e945b;
			font-weight: 500;
			width: 80%;
			font-size: 23px;
			text-align: center;
		}
		// item盒子
		.list_item {
			margin: 10px auto;
			display: flex;
			width: 80%;
			justify-content: flex-start;
			align-items: center;
			// label
			.list_label {
				color: #6e945b;
				background: #6e945b10;
				width: 130px;
				font-size: 14px;
				line-height: 36px;
				box-sizing: border-box;
				text-align: right;
			}
			// 输入框
			:deep(.list_inp) {
				border: 0px solid #ddd;
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				background: #6e945b10;
				flex: 1;
				width: 100%;
				line-height: 36px;
				box-sizing: border-box;
				height: 36px;
				//去掉默认样式
				.el-input__wrapper{
					border: none;
					box-shadow: none;
					background: none;
					border-radius: 0;
					height: 100%;
					padding: 0;
				}
				.is-focus {
					box-shadow: none !important;
				}
			}
		}
		//按钮盒子
		.list_btn {
			margin: 10px auto;
			display: flex;
			width: 80%;
			align-items: center;
			flex-wrap: wrap;
			//注册按钮
			.register {
					border: none;
					border-radius: 0px;
					margin: 0 auto;
					color: #fff;
					background: #6e945b;
					width: 100%;
					font-size: 16px;
					height: 40px;
			}
			//注册按钮悬浮样式
			.register:hover {
				border: none;
				border-radius: 0;
				background: #19a97b;
				width: 100%;
				font-size: 16px;
				height: 40px;
			}
			//已有账号
			.r-login {
				cursor: pointer;
				padding: 10px 0 0;
				color: #999;
				width: 100%;
				font-size: 14px;
				text-align: right;
			}
		}
		//图片上传样式
		.list_file_list  {
			//提示语
			:deep(.el-upload__tip){
				margin: 7px 0 0;
				color: #999;
				display: flex;
				font-size: 14px;
				justify-content: flex-start;
				align-items: center;
			}
			//外部盒子
			:deep(.el-upload--picture-card){
				border: 1px solid #6e945b30;
				cursor: pointer;
				background-color: #6e945b10;
				border-radius: 0px;
				width: 160px;
				line-height: 70px;
				text-align: center;
				height: 60px;
				//图标
				.el-icon{
					color: #999;
					font-size: 32px;
				}
			}
			:deep(.el-upload-list__item) {
				border: 1px solid #6e945b30;
				cursor: pointer;
				background-color: #6e945b10;
				border-radius: 0px;
				width: 160px;
				line-height: 70px;
				text-align: center;
				height: 60px;
			}
		}
	}
</style>