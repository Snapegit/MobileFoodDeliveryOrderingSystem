const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/cl5033434/front/h5/index.html'
        }
    },
    getProjectName(){
        return {
            projectName: "基于前后端分离的外卖点餐系统"
        } 
    }
}
export default config
