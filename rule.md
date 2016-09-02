##命名规则
###变量
1. 控件：
 - java：小写缩写+含义
如ivImage(ImageView)、tvNmae(TextView)
 - xml：缩写_含义
如iv_image(ImageView)、tv_name(TextView)

###类名

##layout文件
1. root控件必须为ViewGroup
不允许SingleView直接作为一个layout

##初始值
如果初始值有实际意义，则无法判断该值是自动初始化还是用户设定。此处初始值并非默认值，默认值必须为实际值的子集。
1. 定义基本类型变量时必须设置初始值
1. 初始值不能为实际值的子集
