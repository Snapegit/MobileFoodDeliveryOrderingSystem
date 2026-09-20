	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import news from '@/views/news/list'
	import qishou from '@/views/qishou/list'
	import address from '@/views/address/list'
	import dingdanxinxi from '@/views/dingdanxinxi/list'
	import peisongxinxi from '@/views/peisongxinxi/list'
	import discussorders from '@/views/discussorders/list'
	import caipinxinxi from '@/views/caipinxinxi/list'
	import shangjia from '@/views/shangjia/list'
	import users from '@/views/users/list'
	import cart from '@/views/cart/list'
	import caipinfenlei from '@/views/caipinfenlei/list'
	import yonghu from '@/views/yonghu/list'
	import orders from '@/views/orders/list'
	import discusscaipinxinxi from '@/views/discusscaipinxinxi/list'
	import config from '@/views/config/list'
	import qishouRegister from '@/views/qishou/register'
	import qishouCenter from '@/views/qishou/center'
	import shangjiaRegister from '@/views/shangjia/register'
	import shangjiaCenter from '@/views/shangjia/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/qishouCenter',
			name: '骑手个人中心',
			component: qishouCenter
		}
		,{
			path: '/shangjiaCenter',
			name: '商家个人中心',
			component: shangjiaCenter
		}
		,{
			path: '/news',
			name: '美食资讯',
			component: news
		}
		,{
			path: '/qishou',
			name: '骑手',
			component: qishou
		}
		,{
			path: '/address',
			name: '地址',
			component: address
		}
		,{
			path: '/dingdanxinxi',
			name: '订单信息',
			component: dingdanxinxi
		}
		,{
			path: '/peisongxinxi',
			name: '配送信息',
			component: peisongxinxi
		}
		,{
			path: '/discussorders',
			name: '商品订单',
			component: discussorders
		}
		,{
			path: '/caipinxinxi',
			name: '菜品信息',
			component: caipinxinxi
		}
		,{
			path: '/shangjia',
			name: '商家',
			component: shangjia
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/cart',
			name: '购物车',
			component: cart
		}
		,{
			path: '/caipinfenlei',
			name: '菜品分类',
			component: caipinfenlei
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/orders',
			name: '订单管理',
			component: orders
		}
		,{
			path: '/discusscaipinxinxi',
			name: '菜品信息评论',
			component: discusscaipinxinxi
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		]
	},
	{
		path: '/qishouRegister',
		name: '骑手注册',
		component: qishouRegister
	},
	{
		path: '/shangjiaRegister',
		name: '商家注册',
		component: shangjiaRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
