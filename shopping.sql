# Host: localhost  (Version: 5.5.15)
# Date: 2018-11-30 16:00:48
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "commoditytype"
#

CREATE TABLE `commoditytype` (
  `typeId` int(20) NOT NULL,
  `typeName` varchar(20) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "commoditytype"
#


#
# Structure for table "commodity"
#

CREATE TABLE `commodity` (
  `cId` int(20) NOT NULL,
  `typeId` int(20) DEFAULT NULL,
  `cName` varchar(20) NOT NULL,
  `price` float NOT NULL,
  `des` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cId`),
  UNIQUE KEY `cName` (`cName`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `commoditytype` (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "commodity"
#


#
# Structure for table "user"
#

CREATE TABLE `user` (
  `uId` int(20) NOT NULL,
  `username` int(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#


#
# Structure for table "orders"
#

CREATE TABLE `orders` (
  `old` int(20) NOT NULL,
  `uId` int(20) DEFAULT NULL,
  `cId` int(20) DEFAULT NULL,
  `num` int(20) NOT NULL,
  `status` int(20) NOT NULL,
  `price` int(20) NOT NULL,
  PRIMARY KEY (`old`),
  KEY `uId` (`uId`),
  KEY `cId` (`cId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uId`) REFERENCES `user` (`uId`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`cId`) REFERENCES `commodity` (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "orders"
#

insert into commoditytype
(typeId,typeName)
values
(0,'电子书'),
(1,'小说'),
(2,'漫画'),
(3,'科技'),
(4,'童书');

insert into commodity
(cId,typeId,cName,price,des,image)
values
(1,0,'我们都是宇宙中的微尘',23.40,'本书为李银河随笔新作，收录了她对人生本质、自我存在的价值、交友之道、激情之爱、生活方式、艺术与阅读等问题的思考。','http://img60.ddimg.cn/digital/product/1/58/1901100158_ii_cover.jpg?version=e5e16431-65df-43f8-869e-cea84c738a74'),
(2,0,'刺客之死',49.90,'他是逃亡国外的亡命刺客，为阻止俄国被卷一战，只身来到伦敦暗杀俄国使臣。丘吉尔和整个伦敦的警察向他步步紧逼，行刺过程困难重重。','http://img60.ddimg.cn/digital/product/27/67/1901092767_ii_cover.jpg?version=dfd47005-11a3-4ebd-b2e4-dab7c0224cd5'),
(3,0,'奥德赛',15.80,'诗作战争描写之恢宏，结构布局之精美，堪称欧洲叙事诗的典范，是古希腊文学辉煌期的代表作','http://img60.ddimg.cn/digital/product/67/10/1900676710_ii_cover.jpg?version=59edd217-baf1-4dae-9e8f-b639ecdaa1cb555'),
(4,0,'存在之轻',19.90,'几乎在不知不觉中，我们对自然界*深层次实在的理解在过去的四分之一世纪里已经有了重大改变、现在我们己非常接近于长期寻求的突破','http://img61.ddimg.cn/digital/product/47/44/1901054744_ii_cover.jpg?version=b17d81ca-127f-4fd0-9fbd-e4ac203f7232'),
(5,0,'九三年',2.99,'描绘了资产阶级和封建势力在一七九三年行殊死搏斗的历史场面','http://img62.ddimg.cn/digital/product/83/72/1900748372_ii_cover.jpg?version=3dc3e86d-fc6c-49cf-bec7-0d250063aaca555'),
(6,0,'纳尼亚传奇',19.90,'The Chronicles of Narnia is a series of seven high fantasy novels by author C. S. Lewis. ','http://img61.ddimg.cn/digital/product/71/53/1901077153_ii_cover.jpg?version=79dd603f-6f25-45bc-a247-c6336eb43bbc'),
(7,0,'时间之箭',19.90,'论证了现代科学理论关于时间的*普遍观','http://img61.ddimg.cn/digital/product/10/86/1901071086_ii_cover.jpg?version=a1462569-91a5-4040-86cc-96a64826a952'),
(8,0,'解除限速',25.20,'他从长途大巴跳下，在一个陌生的小镇展全新生活','http://img60.ddimg.cn/digital/product/19/12/1901091912_ii_cover.jpg?version=1b097483-605e-4a4b-b3dd-3bd72112dfc1'),
(9,0,'就你戏最多',39.90,'爱演又想快速赚大钱的王帅在“顺利”成为群演后，和一群二货始了他的戏精养成之路…… ','http://img62.ddimg.cn/digital/product/39/75/1901093975_ii_cover.jpg?version=1cb7c1e3-d3d0-40e2-a314-1a13f4694608'),
(10,0,'寻找自己',15.90,'身处当前社会转型时期，面对浮躁的人性，思想引领不可或缺。','http://img61.ddimg.cn/digital/product/23/61/1901092361_ii_cover.jpg?version=766ee279-7506-4484-be16-49dda92e3ab7'),
(11,1,'摆渡人',29.90,'如果命运是一条孤独的河流，谁会是你灵魂的摆渡人？如果我真的存在，也是因为你需要我','http://img3m7.ddimg.cn/86/32/23694647-1_w_8.jpg'),
(12,1,'熊镇',22.50,'全球热销1300万，备受林彦俊、马思纯、 张皓宸、 池昌旭推崇','http://img3m0.ddimg.cn/54/24/25859250-1_w_4.jpg'),
(13,1,'滴泪痣',45.00,'一生流水，半世飘蓬，一段注定滴泪的爱，林少华激赏，李修文成名作，中国版《挪威的森林》','http://img3m4.ddimg.cn/44/3/25185644-1_w_1.jpg'),
(14,1,' 张大小姐',22.50,'一部讲述上流社会、精英人群的时尚悬念爱情侦探小说，出身豪门的红三代，公关一姐和时尚教母们，面对名利和欲望，显露虚荣本质，姚晨，谭卓倾力推荐。','http://img3m4.ddimg.cn/25/8/25548064-3_w_2.jpg'),
(15,1,'偷影子的人',21.80,'此版本售罄不再加印，如有需要请购买新版：《偷影子的人（2018新版）》','http://img3m9.ddimg.cn/50/30/22788959-1_w_3.jpg'),
(16,1,'小小小小的火',26.00,'又是她，征服欧美文坛的华裔作家！新作再夺2017美国年度小说桂冠！永远记得，你呼吸着的每一个瞬间，都应该去过你真正想要的生活。','http://img3m2.ddimg.cn/34/7/25263052-1_w_3.jpg'),
(17,1,'星尘',27.50,'《美国众神》作者尼尔·盖曼无比浪漫的奇幻经典！','http://img3m4.ddimg.cn/65/11/25328324-1_w_2.jpg'),
(18,1,'祖与占：夏日之恋',32.30,'著名诗人夏宇翻译，法国经典爱情电影《祖与占》原著小说','http://img3m8.ddimg.cn/49/33/25478788-1_w_2.jpg'),
(19,1,'巨人的陨落',89.60,'全球读者平均3个通宵读完的超级巨著。全球每三秒卖出一本！十年来，横扫欧美16国排行榜的超级小说。','http://img3m4.ddimg.cn/26/10/23951294-1_w_23.jpg'),
(20,1,'追风筝的人',24.80,'为你，千千万万遍！快乐大本营高圆圆感动推荐，朗读者张一山深情诵读，窦靖童创作灵感的来源，奥巴马送给女儿的新年礼物','http://img3m5.ddimg.cn/26/14/25238195-1_w_3.jpg'),
(21,2,'就喜欢你看不惯我又干不掉我的样子',92.00,'吾皇巴扎黑、牛能联袂出镜,当当网独家附赠吾皇密旨！密旨惊喜，还有超萌表情贴纸！','http://img3m7.ddimg.cn/54/4/23981517-1_w_8.jpg'),
(22,2,'咔嚓！老田就爱高丽丽',45.00,'相爱就是表面互相嫌弃，内心不离不弃！','http://img3m8.ddimg.cn/80/20/25205678-1_w_3.jpg'),
(23,2,'我的错都是大人的错',33.00,'大人和小孩之间的矛盾，几米*明白，他完全相信孩子是天使和恶魔一体的两面。','http://img3m5.ddimg.cn/61/21/23387425-1_w_3.jpg'),
(24,2,' 灯塔',76.80,'这是一部探索现代人内在情感的图像小说','http://img3m2.ddimg.cn/19/20/23853772-1_w_3.jpg'),
(25,2,' 神兽退散',14.80,'《神兽退散》讲述了一条叫烛阴的龙，','http://img3m1.ddimg.cn/3/17/25535271-1_w_6.jpg'),
(26,2,'肚子饿万岁',22.00,'写给所有年轻人16个关于爱和美食的温暖故事！','http://img3m7.ddimg.cn/9/31/23698827-1_w_3.jpg'),
(27,2,'我可以咬一口吗',24.50,'超治愈系漫画即将再度萌爆你的朋友圈','http://img3m9.ddimg.cn/68/22/23946089-1_w_30.jpg'),
(28,2,'是我把你弄哭了吗？',39.90,'那些动物们的心酸冷知识。152只呆萌小动物悄悄告诉你152个催泪冷知识。','http://img3m2.ddimg.cn/94/20/24161242-1_w_11.jpg'),
(29,2,'爆笑校园',63.20,'图书市场畅销常销的奇迹。国产搞笑经典漫画的标杆。','http://img3m0.ddimg.cn/42/35/22924680-1_w_1.jpg'),
(30,2,'回答不了',50.00,'横空出世的天才漫画家匡扶摇，感动千万读者的“回答不了”系列首次结集。','http://img3m0.ddimg.cn/63/23/25479000-5_w_5.jpg'),
(31,3,'C++ Primer Plus',67.20,'畅销20余年的C++编程入门教程 近百万程序员的C++编程启蒙教程','http://img3m4.ddimg.cn/40/14/22783504-1_w_4.jpg'),
(32,3,'C Primer Plus 第6版',66.80,'技术大牛案头常备的工具书 针对C11标准库更新','http://img3m2.ddimg.cn/43/13/23958142-1_w_12.jpg'),
(33,3,' Python神经网络编程',54.50,'人工智能深度学习机器学习领域又一重磅力作 自己动手用Python编写神经网络','http://img3m5.ddimg.cn/78/36/25251315-1_w_6.jpg'),
(34,3,'Head First Java',54.30,'10年畅销经典，累计印刷30多次，畅销10万余册，计算机图书十大好书之一。','http://img3m9.ddimg.cn/56/36/9265169-1_w_5.jpg'),
(35,3,'编程珠玑',27.50,'20余年畅销不衰计算机科学的不朽经典','http://img3m2.ddimg.cn/43/16/23640352-1_w_1.jpg'),
(36,3,'TensorFlow',79.20,'领域旗舰重磅升级 新老谷歌专家联袂 首度全面支持1.4.x代码','http://img3m1.ddimg.cn/0/27/25224111-1_w_6.jpg'),
(37,3,' 奇点临近',47.90,'一部预测人工智能和科技未来的奇书。','http://img3m6.ddimg.cn/4/35/22518346-1_w_2.jpg'),
(38,3,'码农翻身',61.40,'用故事给技术加点料，全网阅读量近1000万次的技术故事','http://img3m4.ddimg.cn/31/12/25276414-1_w_13.jpg'),
(39,3,'笨办法学Python 3',46.60,'经典畅销Python入门教程升级版 Python3编程从入门到实践教程','http://img3m2.ddimg.cn/29/31/25286312-1_w_3.jpg'),
(40,3,' 物联网安全',37.70,'面向“网络”和“网络安全”研究人员和从业人员，重点描述和分析*重要的安全风险和威胁','http://img3m7.ddimg.cn/14/15/25575377-2_w_3.jpg'),
(41,4,'大中华寻宝系列25 河北寻宝记',23.40,'在阅读中了解华夏人文地理，在寻宝中探索中华文化精华','http://img3m1.ddimg.cn/10/24/25575571-1_w_3.jpg'),
(42,4,' 不可不知的人体',44.10,'国际畅销科普书作家约翰·范登全新作品','http://img3m8.ddimg.cn/57/15/25537008-1_w_3.jpg'),
(43,4,'蹦蹦跳跳的故事',121.60,'荣获德国童书权威奖项——德国青少年文学奖图画书荣誉奖','http://img3m5.ddimg.cn/38/6/25547285-4_w_3.jpg'),
(44,4,'地球的孩子',34.30,'博洛尼亚童书展获奖绘者联手美国儿童诗歌桂冠诗人，用画与诗为孩子打开一扇感悟自然的新视窗。','http://img3m1.ddimg.cn/32/21/25535201-1_w_6.jpg'),
(45,4,'阁楼上的光',39.10,'连续182周位居《纽约时报》畅销书榜','http://img3m0.ddimg.cn/86/35/25578320-2_w_2.jpg'),
(46,4,'魔女宅急便',27.60,'2018年国际安徒生奖得主角野荣子代表作','http://img3m6.ddimg.cn/70/34/25579096-1_w_2.jpg'),
(47,4,'墨多多谜境冒险第7册',19.70,'谜境现已开启，DODO冒险队全部集结，和我们一起勇敢探索，迎接挑战! ','http://img3m5.ddimg.cn/29/29/25575095-1_w_3.jpg'),
(48,4,'奇迹男孩',31.00,'作者回归插画师身份，献给小小读者们！','http://img3m7.ddimg.cn/88/26/25809487-1_w_1.jpg'),
(49,4,'章鱼先生卖雨伞',27.60,'2018年金风车国际青年插画家大赛”大众选择奖,《走出森林的小红帽》作者新作。','http://img3m4.ddimg.cn/42/32/25579464-1_w_3.jpg'),
(50,4,'生肖金猪的礼物',37.20,'历时12年原创、十二生肖图画书收官之作','http://img3m6.ddimg.cn/2/34/25577246-1_w_6.jpg');