/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : academic

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-04-22 20:38:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `member` varchar(100) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `acquisitiondate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `read_num` int(11) DEFAULT '0',
  `ordering` int(11) DEFAULT NULL,
  `toshow` tinyint(4) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of achievement
-- ----------------------------
INSERT INTO `achievement` VALUES ('20', '水稻新品种“金航丝苗”', 'djy', '成果与知识产权科', '<p><strong>成果简介：</strong>“金航丝苗”为早晚兼用型籼稻品种，早造全生育期约130～135天，晚造111～114天；株高112.6～2987.5px，株型好，生势旺，分蘖力强，剑叶长，整齐度好；穗大粒多，结实率高，穗长24.3～617.5px，每穗总粒数127～137.5粒，结实率82.1%～85.1%，千粒重18.4～19.2克；米质优，经鉴定，米质达国标优质1级、省标优质1级，米粒透明无腹白，米饭软顺可口，主要理化指标：整精米率69.5%～70.7%，垩白粒率4%～8%，垩白度0.8%～2.4%，直链淀粉15.0%～17.50%，胶稠度76～80mm，粒长6.7mm，粒型（长宽比）3.4，食味品质分90分。生产上，一般栽培平均亩产可达400～450公斤/亩，高产栽培可达450～500公斤/亩，2006年通过广东省品种审定。</p><p><img src=\"http://kjc.scau.edu.cn/_upload/article/images/8a/0c/f3dee7464c6981b5fd380ce04091/2843a8c2-7217-4c4a-a7fc-ee5933a21009.png\" alt=\"C:\\Users\\Administrator\\Desktop\\种植篇1\\图片3.png\"></p><p><strong>应用前景：</strong>“金航丝苗”适宜广东中部、南部，广西南部，福建南部和海南省全省可作早、晚造种植，广东北部，广西中部、北部，福建中部、北部，江西省，湖南省可作中晚造种植。</p><p><strong>合作方式：</strong>成果转让，合作推广。</p><p><strong>完成人：</strong>陈志强等&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong>020-38604903 <a href=\"mailto:wanghui@scau.edu.cn\" target=\"_blank\" style=\"color: rgb(102, 102, 102);\">wanghui@scau.edu.cn</a></p>', '2019-04-06 00:10:47', '2019-04-06 00:10:47', '4', '1', '1', '9', '1');
INSERT INTO `achievement` VALUES ('21', '克拉莫仙', 'djy', '成果与知识产权科', '<p><strong>兽&nbsp;&nbsp;药&nbsp;名&nbsp;称：</strong>阿莫西林可溶性粉</p><p><strong>批准生产单位：</strong>广东省农业厅</p><p><strong>批&nbsp;&nbsp;准&nbsp;文&nbsp;号：</strong>粤兽药字（2003）X009013</p><p><strong>主&nbsp;&nbsp;治&nbsp;疾&nbsp;病：</strong>呼吸道及消化道等的感染</p><p><strong>药&nbsp;&nbsp;性&nbsp;特&nbsp;点：</strong></p><p>	本品为白色或类白色粉末，对大肠杆菌、变形杆菌、沙门氏菌、嗜血杆菌等有较强作用，对肠球菌、沙门氏菌的作用较氨苄西林强2倍。本品在胃中稳定，口服吸收良好。口服相同浓度，由于特殊的增强因子的作用，较阿莫西林原料的药效提高3倍并克服了部分耐药性。本品使用安全，适合出口及绿色食品生产场的使用。</p>', '2019-04-06 00:06:59', '2019-04-06 00:06:59', '3', '10', '1', '9', '1');
INSERT INTO `achievement` VALUES ('22', '无人机多路飞行轨迹采集分析系统（v1.0）UFTAS', 'djy', '成果与知识产权科', '<p><strong>成果简介：</strong>对农用无人机的飞行状态做到实时检测与控制。特别对于无人机的飞行航线数据、飞行高度、飞行速度、飞行姿态数据等飞行参数需要实时采集与回放分析。另外对于无人机搭载的多路传感器的数据（例如GPS与北斗系统），在特定需求时需要进行同时采集与监测，故设计一款无人机多路飞行轨迹采集分析系统软件能很好的为农业航空应用技术的科研与实践服务。</p><p><strong>应用前景：</strong>与农用无人机很好衔接，效用共通，是对农用无人机信息的采集与监测，服务于无人机。</p><p><strong>合作方式</strong>：面议</p><p><strong>完成人</strong>：李继宇&nbsp;&nbsp;&nbsp;<strong>联系方式</strong>：&nbsp;<a href=\"mailto:13560455485@qq.com\" target=\"_blank\" style=\"color: rgb(0, 0, 255);\">13560455485@qq.com</a></p><p>&nbsp;</p><p>&nbsp;<img src=\"http://kjc.scau.edu.cn/_upload/article/images/8d/d8/6693759549e1b2c70cc71ae7ebff/d7583a8b-c4f3-44ab-b605-a8ad4b791c18.jpg\" alt=\"图片3.jpg\" height=\"358\" width=\"380\"></p><p>图为多路采集轨迹对比图</p><p>&nbsp;</p><p>&nbsp;<img src=\"http://kjc.scau.edu.cn/_upload/article/images/8d/d8/6693759549e1b2c70cc71ae7ebff/57247049-6edc-4c81-a93f-33780fd9c1f3.jpg\" alt=\"图片4.jpg\" height=\"410\" width=\"406\"></p>', '2019-04-06 00:12:40', '2019-04-06 00:12:40', '5', '1', '1', '7', '1');
INSERT INTO `achievement` VALUES ('24', '立体视觉的工件快速识别定位系统', 'djy', '成果与知识产权科', '<p class=\"ql-align-center\"><strong>成果简介</strong>：“立体视觉的工件快速识别定位系统”V1.0是广东神教育部产学研结合项目“视觉三维定位的工业机器人关键技术研究与应用”的研发内容，主要应用于快速识别工件三维真实坐标和姿态。包括摄像机标定、工件识别和定位两个模块，可同时对多个目标进行识别和定位，实现与机器人的实时通信。</p><p><strong>应用前景</strong>：直属教育部产学研结合项目，以现下兴起的工业机器人为着眼点，未来市场广阔。</p><p><strong>合作方式</strong>：面议</p><p><strong>完成人</strong>：邹湘军&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong><a href=\"mailto:xjzou1@163.com\" target=\"_blank\" style=\"color: rgb(0, 0, 255);\">xjzou1@163.com</a></p><p><img src=\"http://kjc.scau.edu.cn/_upload/article/images/3a/ec/412a86c74cbe951eeeaf342d75d0/f9ffe0eb-bf92-43ec-881d-c5f142851927.png\" alt=\"图片5.png\" width=\"320\" height=\"254\"></p><p><img src=\"http://kjc.scau.edu.cn/_upload/article/images/3a/ec/412a86c74cbe951eeeaf342d75d0/b52699ef-9d59-45e7-97a5-bab8903c3042.png\" alt=\"图片5.png\" width=\"321\" height=\"256\"></p><p><img src=\"http://kjc.scau.edu.cn/_upload/article/images/3a/ec/412a86c74cbe951eeeaf342d75d0/75e5b8ab-d0f0-4010-afd7-a9655a959f63.png\" alt=\"图片7.png\" width=\"305\" height=\"241\"></p>', '2019-04-05 23:52:03', '2019-04-05 23:52:03', '7', '2', '1', '8', '1');
INSERT INTO `achievement` VALUES ('25', '莱克多巴胺胶体金免疫检测试纸', 'djy', '成果与知识产权科', '<p><strong>简介：</strong>本实用新型涉及一种莱克多巴胺胶体金免疫检测试纸条，它是由样液吸收层、胶体金标记层、检测反应层及吸水层依次设置在背衬上组成。该快速检测试纸条特异性强，能够实现半定量检测，4-40℃都可使用，3分钟以后便可观察结果，适合于卫生、质监、海关、家畜养殖场等单位或个人对牛奶、肉类等样品中的莱克多巴胺进行快速检测。该成果已申请实用新型专利，申请号：&nbsp;200520136528.8。</p><p><img src=\"http://kjc.scau.edu.cn/_upload/article/images/1b/ba/2d708da1427082d82a017534686d/4150f26c-4cfb-4c72-b65c-ca9d8072877d.jpg\" alt=\"图片10_副本.jpg\" width=\"196\" height=\"221\"></p><p><strong>合作方式：</strong>成果转让、合作推广</p><p><strong>完成人：</strong>孙远明&nbsp;等&nbsp;&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong>020-85283448 ymsun@scau.edu.cn</p>', '2019-04-05 23:52:55', '2019-04-05 23:52:55', '5', '1', '1', '10', '1');
INSERT INTO `achievement` VALUES ('26', '农产品中有机磷农药及克伦特罗等残留快速检测技术与应用', 'djy', '成果与知识产权科', '<p><strong>成果简介：</strong>建立了一项理论基础：农兽药半抗原-抗体构效关系，国际同行认可；突破了半抗原定向设计等多项国际难题，创新了“三类核心原材料、四种核心方法、二种配套仪器”，总体技术水平达到国际领先；申报专利41项，授权12项；发表论文64篇，SCI17篇；鉴定成果3项。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://kjc.scau.edu.cn/_upload/article/images/0b/9f/1099645941b6abbc79b0ba78819f/81be0b9c-9280-4a21-b64e-70b2b55ad09b.jpg\" alt=\"图片6.jpg\" width=\"1840\" height=\"1659\"></p><p><span class=\"ql-cursor\">﻿</span><img src=\"http://kjc.scau.edu.cn/_upload/article/images/0b/9f/1099645941b6abbc79b0ba78819f/1181732f-fd67-47da-8729-a3972eef7666.jpg\" alt=\"å¾ç7.jpg\"></p><p><br></p><p><strong>应用前景：</strong>应用5000万份，对保障广大消费者的身心健康、促进行业技术进步、社会和谐和国际贸易等发挥了重要作用；新增产值1.3亿元，利税3000多万元，节支增收95.7亿元；三大类近20种产品实现产业化，方便，快捷，准确，成本低廉，实用性强，符合中国国情；带动食品安全快速检测技术发展；预计年应用量1亿份以上，年创经济效益100亿以上。</p><p><strong>合作方式：</strong>成果转让、合作推广</p><p><strong>完成人：</strong>孙远明&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong>020-85283448 ymsun@scau.edu.cn&nbsp;&nbsp;&nbsp;</p>', '2019-04-05 23:52:47', '2019-04-05 23:52:47', '7', '1', '1', '9', '1');
INSERT INTO `achievement` VALUES ('27', '岩质边坡绿化基质生产及应用技术', 'djy', '成果与知识产权科', '<p><strong>成果简介：</strong>本项目针对目前国内外岩石和水泥坡面绿化以及矿区生态恢复工程主要采用椰渣、木屑等为基质，植物养分主要靠添加的无机肥料提供，基材的持久供肥性能和保水性能差，绿化效果不理想等问题，利用多种有机废弃物资源通过合理配制和快速腐熟，并引进肥料控释技术、化学保水技术和工程技术，开发出适宜产业化生产的岩石、水泥坡面绿化和矿区生态恢复用环保型高效营养基质生产和应用技术。本技术在香港、东莞等地的应用结果表明：在岩石和水泥坡面绿化以及矿区生态恢复中初始绿化速度快，秋冬季节抗旱保绿能力强，春季复绿早，可实现无养护条件下的长久绿化。本项目获2006年获国际侵蚀控制协会颁发的环境成就奖（ENVIRONMENTAL&nbsp;ACHIEVEMENT&nbsp;AWARD&nbsp;2006）1项。</p><p class=\"ql-align-center\"><strong>&nbsp;</strong>&nbsp;&nbsp;A、<strong>2003年6月在东莞黄江水泥坡面绿化应用中与进口专用喷播基质的对比试验</strong></p><p class=\"ql-align-center\"><strong><img src=\"http://kjc.scau.edu.cn/_upload/article/images/58/7b/0b1cd5ec453db8c8b9f427690cc9/73fecaa2-9953-4232-a647-47c83af9ac13.png\" alt=\"QQ图片20151116111407.png\"></strong></p><p>&nbsp;</p><p class=\"ql-align-center\">&nbsp;</p><p class=\"ql-align-center\"><strong>B、2004年3月香港某公园岩质坡面绿化应用中与进口专用喷播基质的对比试验</strong></p><p class=\"ql-align-center\"><strong><img src=\"http://kjc.scau.edu.cn/_upload/article/images/58/7b/0b1cd5ec453db8c8b9f427690cc9/9ed3732b-97d9-4827-90be-391e81333788.png\" alt=\"mm.png\" width=\"497\" height=\"190\"></strong></p><p><br></p><p>&nbsp;</p><p><strong>合作方式：</strong>面议</p><p><strong>完成人：</strong>廖宗文等&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong>020-85283066&nbsp;&nbsp;<a href=\"mailto:zwliao@sohu.com\" target=\"_blank\" style=\"color: rgb(102, 102, 102);\">zwliao@sohu.com</a>&nbsp;&nbsp;<a href=\"mailto:xymao@scau.edu.cn\" target=\"_blank\" style=\"color: rgb(102, 102, 102);\">xymao@scau.edu.cn</a></p>', '2019-04-14 16:00:00', '2019-04-05 14:58:02', '0', '1', '1', '8', '1');
INSERT INTO `achievement` VALUES ('28', '一种聚苯乙烯树脂高分子聚合物超渗透膜及其制备方法', 'djy', '成果与知识产权科', '<p><strong>成果简介：</strong>本发明涉及生物高分子材料领域，具体公开了一种聚苯乙烯树脂高分子聚合物超渗透膜及其制备方法。本发明的聚苯乙烯树脂高分子聚合物超渗透膜，由基膜和聚苯乙烯树脂高分子聚合物组成，在基膜上均匀涂一层聚苯乙烯树脂高分子聚合物，干燥，形成聚苯乙烯树脂高分子聚合物超渗透膜，所得超渗透膜孔径小于30纳米。本发明的超渗透膜用于DNA、蛋白质、生物染料的提纯和脱盐，产品回收率在&nbsp;95％以上。对低至1微升的样品都可以进行纯化，这是其它纯化方法难以达到的。该成果已申请发明专利，申请号：200610034622.1。</p><p><strong>合作方式：</strong>面议</p><p><strong>完成人：</strong>谭志远等&nbsp;&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong>020-85288311&nbsp;&nbsp;&nbsp;<a href=\"mailto:zytan@scau.edu.cn\" target=\"_blank\" style=\"color: rgb(0, 0, 255);\">zytan@scau.edu.cn</a></p>', '2019-04-05 23:53:16', '2019-04-05 23:53:16', '8', '1', '1', '8', '1');
INSERT INTO `achievement` VALUES ('29', '制造刨花板的方法', 'djy', '成果与知识产权科', '<p><strong>成果简介：</strong>本发明涉及一种制造刨花板的方法，特别是一种利用抽提处理工艺制造刨花板的方法。本发明制造刨花板的方法包括在刨花板生产现有工序、木材碎料抽提处理和施胶量降为6-8％。本发明的制造刨花板的方法的优点和积极效果在于只增加木材碎料抽提处理工序，刨花板生产的其它工序不变，施加6-8％的脲醛树脂胶黏剂或改性脲醛树脂胶黏剂就可制造出甲醛释放量低于9mg/100g的刨花板，其强度达到或超过国家标准GB/T&nbsp;4897-2003(在干燥状态下使用的家具及室内装修用刨花板物理力学性能指标)的要求。本发明可提升刨花板制造技术、降低生产成本和甲醛释放量、延长产业链增强企业竞争力等优点。该成果已申请发明专利，申请号：&nbsp;200610011407.X。</p><p><strong>合作方式：</strong>面议</p><p><strong>完成人：</strong>李凯夫等&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong>&nbsp;020-85280257&nbsp;&nbsp;<a href=\"mailto:kfli@scau.edu.cn\" target=\"_blank\" style=\"color: rgb(102, 102, 102);\">kfli@scau.edu.cn</a></p>', '2019-04-12 16:00:00', '2019-04-05 15:00:12', '0', '1', '1', '8', '1');
INSERT INTO `achievement` VALUES ('30', 'T-MAIL可信邮件系统', 'djy', '成果与知识产权科', '<p><strong>成果简介：</strong>本软件涉及信息安全领域，它涉及一种解决邮件系统的信任管理问题，通过在邮件系统中设计分布式安全管理方案，并采用分布式的邮件评价、并集中式的进行邮件的处理。采用分布式信息管理，实现邮件系统的安全管理。采用基于身份的加密方案实现对邮件的加密及处理，它以邮件地址作为收件人身份，实现分加密，可以效地提高邮件内容的安全管理。</p><p><img src=\"http://kjc.scau.edu.cn/_upload/article/images/dd/f3/c362f830431984293919c18b6aa6/c2206ad3-c20d-4e14-b215-b632f689320a.jpg\" alt=\"图片4.jpg\" width=\"309\" height=\"484\"></p><p><strong>应用前景：</strong>对恶意邮件的识别，采用BAYES模型与CLOUD模型结合，有效地提高了对垃圾邮件和恶意邮件的识别效率，加强了邮件处理的稳定和有效性。</p><p><strong>合作方式：</strong>技术转让、合作开发</p><p><strong>完成人：</strong>张明武、杨波&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>联系方式：</strong>020-85285383 zhangmw@scau.edu.cn</p>', '2019-04-05 23:50:32', '2019-04-05 23:50:32', '2', '1', '1', '7', '1');
INSERT INTO `achievement` VALUES ('31', '3D打印用生物质复合材料的生产技术与开发', 'djy', '周武艺 ', '<p><strong>成果简介：</strong>该技术将农林废料如木材、竹纤维、甘蔗渣等经过化学方法改性处理后与可降解的生物高分子材料复合制备系列新型3D打印生物质材料，可广泛用于3D打印家具、塑料制品、模型模具等领域。附加值高、生产工艺简单可实现产业化。目前该技术已经通过了实验室制备和中试放大，进入了大规模生产阶段。</p><p><strong>应用前景：</strong>该技术获得2015年广东省科技厅应用型科技研发专项的支持，研究的相关成果申请了2项国家了国家发明专利。市场应用前景广阔，市场竞争力强，投资小，生产成本低，易产业化。</p><p><strong>合作方式：</strong>面议</p><p><strong>完成人：</strong>周武艺&nbsp;&nbsp;<strong>联系方式：&nbsp;</strong><a href=\"mailto:zhouwuyi@scau.edu.cn\" target=\"_blank\" style=\"color: rgb(0, 0, 255);\">zhouwuyi@scau.edu.cn</a></p><p class=\"ql-align-center\"><img src=\"http://kjc.scau.edu.cn/_upload/article/images/88/06/8e9919e1421ab9144ac274f3aa4e/b958e6b1-f414-4fcc-8d99-9377a1cf638b.jpg\" alt=\"图片14.jpg\" width=\"327\" height=\"256\">&nbsp;</p><p class=\"ql-align-center\">图为专利书</p><p class=\"ql-align-center\">&nbsp;<img src=\"http://kjc.scau.edu.cn/_upload/article/images/88/06/8e9919e1421ab9144ac274f3aa4e/85df1090-0a86-48a1-b8f5-6d3904653600.jpg\" alt=\"图片15.jpg\"></p><p class=\"ql-align-center\"><strong>&nbsp;</strong></p><p class=\"ql-align-center\">&nbsp;</p><p class=\"ql-align-center\">图为3d打印用木塑复合材料</p><p class=\"ql-align-center\">&nbsp;<img src=\"http://kjc.scau.edu.cn/_upload/article/images/88/06/8e9919e1421ab9144ac274f3aa4e/e51e7b2d-3806-47b9-9881-c896174f902f.jpg\" alt=\"图片16.jpg\" width=\"418\" height=\"299\"></p><p class=\"ql-align-center\">图为3d打印木塑复合材料应用作品</p><p><br></p>', '2019-04-05 23:50:34', '2019-04-05 23:50:34', '5', '1', '1', '8', '1');

-- ----------------------------
-- Table structure for achievementphoto
-- ----------------------------
DROP TABLE IF EXISTS `achievementphoto`;
CREATE TABLE `achievementphoto` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) DEFAULT NULL,
  `photo_name` varchar(50) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of achievementphoto
-- ----------------------------
INSERT INTO `achievementphoto` VALUES ('12', '1551020922920微信图片.png', '微信图片.pn', '1');

-- ----------------------------
-- Table structure for achievementread
-- ----------------------------
DROP TABLE IF EXISTS `achievementread`;
CREATE TABLE `achievementread` (
  `read_id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `read_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`read_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of achievementread
-- ----------------------------
INSERT INTO `achievementread` VALUES ('1', '172.16.30.80', '2', null);
INSERT INTO `achievementread` VALUES ('2', '172.16.30.80', '0', null);
INSERT INTO `achievementread` VALUES ('3', '172.16.30.80', '0', null);
INSERT INTO `achievementread` VALUES ('4', '172.16.30.80', '0', null);
INSERT INTO `achievementread` VALUES ('5', '172.16.30.80', '0', null);
INSERT INTO `achievementread` VALUES ('6', '172.16.30.80', '0', null);
INSERT INTO `achievementread` VALUES ('7', '172.16.30.80', '0', null);
INSERT INTO `achievementread` VALUES ('8', null, '0', '2019-04-05 16:06:59');
INSERT INTO `achievementread` VALUES ('9', null, '0', '2019-04-05 16:10:47');
INSERT INTO `achievementread` VALUES ('10', null, '0', '2019-04-05 16:12:41');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `college_id` int(11) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '数学与信息学院', null);
INSERT INTO `college` VALUES ('2', '农学院', null);
INSERT INTO `college` VALUES ('3', '园艺学院', null);
INSERT INTO `college` VALUES ('4', '动物科学学院', null);
INSERT INTO `college` VALUES ('5', '水利与土木工程学院', null);
INSERT INTO `college` VALUES ('6', '食品学院', null);
INSERT INTO `college` VALUES ('7', '电子工程学院', null);
INSERT INTO `college` VALUES ('8', '工程学院', null);
INSERT INTO `college` VALUES ('9', '人文与法学学院', null);
INSERT INTO `college` VALUES ('10', '外国语学院', null);
INSERT INTO `college` VALUES ('11', '艺术学院', null);

-- ----------------------------
-- Table structure for essay
-- ----------------------------
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `summary` varchar(2000) DEFAULT NULL,
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `hold_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `location` varchar(20) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `precautions` varchar(100) DEFAULT NULL,
  `fund` varchar(10) DEFAULT NULL,
  `organizer` varchar(100) DEFAULT NULL,
  `planned_attendance` int(11) DEFAULT NULL,
  `actual_attendance` int(11) DEFAULT NULL,
  `ordering` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `read_num` int(11) DEFAULT '0',
  `toshow` tinyint(4) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of essay
-- ----------------------------
INSERT INTO `essay` VALUES ('7', 'Almost periodic attractor for Lorenz-like system', 'djy', ' In this talk, global dynamics of the Lorenz-like system with almost periodic forcing are discussed, and some new results are presented.Almost periodic attractor is analyzed for the system, and the bifurcation phenomenon in the driven system.      ', '2019-04-05 17:03:00', '2019-04-05 17:03:00', '数学系713室', '<p>报告人简介：</p><p>&nbsp;&nbsp;&nbsp;&nbsp;刘永建，教授,玉林师范学院数学与统计学院院长，硕士研究生导师。广西高校卓越学者，广西科学技术奖自然科学奖和广西高校自治区级教学成果奖获得者，非线性系统数据分析与应用广西高校高水平创新团队负责人，信息与计算科学广西本科高校特色专业及实验实训教学基地负责人，广西高校复杂系统优化与大数据处理重点实验室秘书、学术委员会委员。现任广西师范大学、广西民族大学、闽南师范大学兼职硕士研究生导师。曾入选广西高校优秀人才资助计划、广西高校优秀中青年教师骨干培养工程。主要从事混沌理论与应用方面的研究，近5年主持国家自然科学基金项目2项、广西自然科学基金项目3项(重点项目1项)，在国内外重要学术刊物上发表论文50余篇，其中SCI收录20多篇。&nbsp;&nbsp;&nbsp;&nbsp;</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;欢迎广大师生参加！</p>', null, '0', '袁利国  副教授', '200', null, '0', '1', '2', null, '1');
INSERT INTO `essay` VALUES ('8', '回归中的识别检验——一个架于局部和全局平滑方法间的方法', 'djy', 'For regression models, most of existing specification tests can be categorized into the class of local smoothing tests and of global smoothing tests. Compared with global smoothing tests, local smoothing tests can only detect local alternatives distinct from the null hypothesis at a much slower rate when the dimension of predictor vector is high, but can be more sensitive to oscillating alternatives. In this paper, we suggest a projection-based test to bridge between the local and global smoothing-based methodologies such that the test can benefit from the advantages of these two types of tests. The test construction is based on a kernel estimation-based method and the resulting test becomes a distance-based test with a closed form. The asymptotic properties are investigated. Simulations and a real data analysis are conducted to evaluate the performance of the test in finite sample cases.', '2019-04-03 23:46:57', '2019-04-03 23:46:57', '数学与信息学院201报告厅', '<p>报告人简介：</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;朱力行教授，长江学者讲座教授，博士生导师。研究领域包括高维数据分析、统计学中的Monte Carlo方法、非参数/半参数统计、经验过程理论、生物统计与生物信息论、经济计量学等。朱力行教授，1990年在中国科学院获得理学博士，1993年在中国科学院应用数学所评为研究员/博士导师。1998年去香港大学统计与精算系工作，2005年到香港浸会大学数学系工作，现在是统计学讲座教授。曾经担任两届系主任。1998年获得德国洪堡研究奖，是自然科学，工程，医学领域中，大陆，香港，台湾，澳门第一位获奖者，迄今为止，还是亚洲统计学界唯一获奖者。2003年，2007年和2015年分别当选为美国数理统计研究院fellow和国际统计研究院(ISI) elected member，美国统计协会fellow和美国科学促进会（AAAS）fellow。2013年获得中国国家自然科学奖二等奖（独立）。1997年获得杰出青年基金资助，1999年入选中科院百人计划。2004年获选为长江讲座教授。</p><p><br></p><p>欢迎师生莅临参加!</p>', null, '0', '朱力行教授', '100', null, '0', '7', '0', '2', '1');
INSERT INTO `essay` VALUES ('9', '秩：带有图形非线性仿射的大规模推断', 'djy', 'Power and reproducibility are key to enabling refined scientific discoveries in contemporary big data applications with general high-dimensional nonlinear models. In this paper, we provide theoretical foundations on the power and robustness for the model- X knockoffs procedure introduced recently in Cand`es, Fan, Janson and Lv (2018) in high-dimensional setting when the covariate distribution is characterized by Gaussian graphical model. We establish that under mild regularity conditions, the power of the oracle knockoffs procedure with known covariate distribution in high-dimensional linear models is asymptotically one as sample size goes to infinity. When moving away from the ideal case, we suggest the modified model-X knockoffs method called graphical nonlinear knockoffs (RANK) to accommodate the unknown covariate distribution. We provide theoretical justifications on the robustness of our modified procedure by showing that the false discovery rate (FDR) is asymptotically controlled at the target level and the power is asymptotically one with the estimated covariate distribution. To the best of our knowledge, this is the first formal theoretical result on the power for the knockoffs procedure. Simulation results demonstrate that compared to existing approaches, our method performs competitively in both FDR control and power. A real data set is analyzed to further assess the performance of the suggested knockoffs procedure.', '2019-04-03 15:48:18', '2019-01-13 06:30:00', '数学与信息学院201报告厅', '<p>报告人简介：</p><p>&nbsp;&nbsp;&nbsp;李高荣，北京工业大学北京科学与工程计算研究院教授，博士生导师。华东师范大学和美国南加州大学博士后，全国工业统计学教学研究会常务理事、中国概率统计学会理事、北京应用统计学会常务理事、中国现场统计研究会高维数据统计分会理事、生存分析分会理事和副秘书长和美国数学评论评论员。多次访问香港浸会大学，新加坡南洋理工大学和香港城市大学。主要研究方向是非参数统计、高维统计、统计学习、纵向数据、测量误差数据和因果推断等。迄今为止，在统计学top期刊《Annals of Statistics》, 《Journal of the American Statistical Association》,以及一些知名的统计期刊《 Statistics and Computing》, 《Statistica Sinica》等杂志上发表学术论文80多篇，被SCI和SSCI收录50多篇。在科学出版社出版专著《纵向数据半参数模型》和《现代测量误差模型》，后者入选《现代数学基础丛书》系列。入选北京市属高等学校人才强教深化计划“中青年骨干人才培养计划”，北京市优秀人才培养资助计划和北京工业大学“京华人才”支持计划。主持国家自然科学基金、北京市自然科学基金和北京市教委科技计划面上项目等国家和省部级科研项目10余项。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;欢迎广大师生参加！</p>', null, '0', '李高荣教授', '100', null, '0', '7', '0', null, '1');
INSERT INTO `essay` VALUES ('10', '胡声琴语——二胡音乐鉴赏会', 'djy', '无', '2019-04-03 15:54:05', '2019-04-03 06:00:00', '华南农业大学第三教学楼609', '<p>主讲人简介：</p><p>李寒晖，广东省民族管弦乐学会会员，广州民族乐团二胡演奏员，广州市文化馆二胡教师，广州市老干大学二胡教师。</p><p>讲座内容：</p><p>1、胡琴的种类；</p><p>2、二胡的起源与发展；</p><p>3、二胡构造及发声原理；</p><p>4、二胡曲目类别及赏析；</p><p>5、互动（现场试奏二胡）</p>', null, '0', '李寒晖', '100', null, '0', '5', '0', null, '1');
INSERT INTO `essay` VALUES ('11', '动科大讲坛', 'djy', '肉羊多胎功能基因挖掘及克隆胚胎重编程机制的研究', '2019-04-05 12:41:49', '2019-01-02 16:00:00', '动科大讲坛报告厅', '<p><strong style=\"color: rgb(0, 32, 96);\">时间：2019年1月4日（周五）上午10:00</strong></p><p><strong style=\"color: rgb(0, 32, 96);\">地点：动科大讲坛报告厅</strong></p><p><strong style=\"color: rgb(0, 32, 96);\">题目：肉羊多胎功能基因挖掘及克隆胚胎重编程机制的研究</strong></p><p><strong style=\"color: rgb(0, 32, 96);\">主讲人：王锋教授</strong></p><p><strong>王锋：</strong>南京农业大学动科学院二级教授、博士、博导。国家重点研发计划项目（山羊）首席专家、国家肉羊产业技术体系-生产与环境控制功能研究室主任、岗位专家，江苏省现代农业（肉羊）产业技术体系首席专家，江苏省农业重大新品种创制项目（山羊）首席专家；江苏省家畜胚胎工程实验室主任、肉羊健康养殖创新团队首席专家；校动物生物工程博士点点长、羊业科学研究所所长。兼任中国畜牧兽医学会动物繁殖学分会副理事长、养羊学分会常务理事等。主要研究方向为动物胚胎工程、生殖调控与羊业科学。主持各类项目课题约40项，获成果及奖励10多项，发表论文300余篇，其中SCI论文100多篇，制定江苏省地方标准5项，授权专利10多个，主编、参编教材及著作30多部，主持的《动物繁殖学》为国家精品资源共享课程。</p><p>&nbsp;&nbsp;</p><p class=\"ql-align-justify\">&nbsp;&nbsp;</p><p><strong>欢迎各位师生届时参加！</strong></p>', null, '0', '王锋教授', '100', null, '0', '10', '0', null, '1');
INSERT INTO `essay` VALUES ('12', '信息安全——认识、入门和提升', 'djy', '信息安全讲座纲要：     1、信息安全就业前景     2、信息安全行业的发展现状     3、信息安全在国家层面的重视程度     4、信息安全在高校的重视程度     5、信息安全的事件介绍     6、信息安全之职业规划     7、CTF入门     8、信息安全学习之路', '2019-04-05 16:34:01', '2019-04-09 16:00:00', '数学与信息学院500课室', '<p>报告人简介：</p><p>&nbsp;&nbsp;&nbsp;&nbsp;<strong>杨志鹏</strong>，西普教育研究院信息安全实验室责人（本科）、CSM专家级讲师。从事信息安全技术研究和管理工作十余年多，精通网络安全架构及安全评估、精通WEB渗透及防御技术。曾参与国产操作系统—中标麒麟的攻防研究和国产金融软硬件攻防研究。曾为国家某安全部门培养信息安全技术人才。曾参与中美意识形态战争的技术研究和框架设计。西普唯一持有中国信息安全测评中心CISP讲师证书资质的讲师。</p><p><br></p><p>欢迎广大师生参加！</p>', null, '0', '杨志鹏 西普教育 高级安全讲师', '100', null, '0', '8', '0', null, '1');

-- ----------------------------
-- Table structure for essayphoto
-- ----------------------------
DROP TABLE IF EXISTS `essayphoto`;
CREATE TABLE `essayphoto` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `photo_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of essayphoto
-- ----------------------------
INSERT INTO `essayphoto` VALUES ('1', '1551938338320微信图片.png', '1', '微信图片.pn');
INSERT INTO `essayphoto` VALUES ('2', '1552894593854微信图片.png', '5', '微信图片.pn');
INSERT INTO `essayphoto` VALUES ('3', '1552894593854微信图片.png', '5', '微信图片.pn');
INSERT INTO `essayphoto` VALUES ('4', '1552894742380微信图片.png', '5', '微信图片.pn');

-- ----------------------------
-- Table structure for essayread
-- ----------------------------
DROP TABLE IF EXISTS `essayread`;
CREATE TABLE `essayread` (
  `read_id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `read_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`read_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of essayread
-- ----------------------------
INSERT INTO `essayread` VALUES ('1', '127.0.0.1', '1', null);
INSERT INTO `essayread` VALUES ('2', '1', '1', null);
INSERT INTO `essayread` VALUES ('3', '172.16.30.80', '1', null);
INSERT INTO `essayread` VALUES ('4', '172.16.30.80', '0', null);
INSERT INTO `essayread` VALUES ('5', '172.16.30.80', '0', null);

-- ----------------------------
-- Table structure for identity
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity` (
  `identity_id` int(11) DEFAULT NULL,
  `access` varchar(20) DEFAULT NULL,
  `identity_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES ('1', '[1,5]', '普通管理员');
INSERT INTO `identity` VALUES ('2', '[1,5,7,9,12,14]', '系统管理员');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `access` varchar(100) DEFAULT NULL,
  `hideInBread` tinyint(4) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `orderIndex` int(11) DEFAULT NULL,
  `icon` varchar(20) DEFAULT NULL,
  `classname` varchar(200) DEFAULT NULL,
  `label` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('7', 'achievementmanage', '/achievementmanage', 'admin', '1', 'Main', '', '', '2', null, 'com.org.graduactionproject.contraller.AchievementContraller', '学术成果管理');
INSERT INTO `menu` VALUES ('8', 'achievementmanage_page', 'achievementmanage_page', 'admin', '0', '/directive/myAchievementManager.vue', '学术成果管理', '7', null, 'ios-book', '', null);
INSERT INTO `menu` VALUES ('11', 'activityholded_page', 'activityholded_page', 'admin', '0', '/directive/essayholded.vue', '已举办活动', '9', null, 'ios-book', null, null);
INSERT INTO `menu` VALUES ('9', 'activitymanage', '/activitymanage', 'admin', '1', 'Main', '学术活动管理', null, '3', null, 'com.org.graduactionproject.contraller.EssayContraller', '学术活动管理');
INSERT INTO `menu` VALUES ('10', 'activitymanage_page', 'activitymanage_page', 'admin', '0', '/directive/myEssay.vue', '未举办活动', '9', null, 'ios-book', null, null);
INSERT INTO `menu` VALUES ('14', 'collegeManager', '/collegeManage', 'sysadmin', '1', 'Main', '', '', '5', null, 'com.org.graduactionproject.contraller.CollegeContraller', '学院管理');
INSERT INTO `menu` VALUES ('15', 'college_page', 'college_page', 'sysadmin', '0', '/directive/collegeManager.vue', '学院管理', '14', null, 'ios-book', null, null);
INSERT INTO `menu` VALUES ('5', 'roleManager', '/roleManager', 'sysadmin', '1', 'Main', null, null, '1', null, 'com.org.graduactionproject.contraller.IdentityCotraller', '角色管理');
INSERT INTO `menu` VALUES ('6', 'role_page', 'role_page', 'sysadmin', '0', '/directive/roleManager.vue', '角色管理', '5', null, 'ios-book', null, null);
INSERT INTO `menu` VALUES ('12', 'subjectmanage', '/subjectmanage', 'admin', '1', 'Main', null, null, '4', '', 'com.org.graduactionproject.contraller.TypeContraller', '学科管理');
INSERT INTO `menu` VALUES ('13', 'subjectmanage_page', 'subjectmanage_page', 'admin', '0', '/directive/myTypeManager.vue', '学科管理', '12', null, 'ios-book', null, null);
INSERT INTO `menu` VALUES ('1', 'usermanage', '/usermanage', 'sysadmin', '1', 'Main', null, null, '0', null, 'com.org.graduactionproject.contraller.UserContraller', '用户管理');
INSERT INTO `menu` VALUES ('2', 'usermanage_page', 'usermanage_page', 'sysadmin', '0', '/directive/myUserMananger.vue', '用户管理', '1', null, 'ios-book', null, null);

-- ----------------------------
-- Table structure for outcome
-- ----------------------------
DROP TABLE IF EXISTS `outcome`;
CREATE TABLE `outcome` (
  `outcome_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(2550) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`outcome_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outcome
-- ----------------------------
INSERT INTO `outcome` VALUES ('6', '<p>dsa</p>', '1');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '法学', null);
INSERT INTO `type` VALUES ('2', '经济学', null);
INSERT INTO `type` VALUES ('3', '哲学', null);
INSERT INTO `type` VALUES ('4', '教育', null);
INSERT INTO `type` VALUES ('5', ' 文学', null);
INSERT INTO `type` VALUES ('6', '历史学', null);
INSERT INTO `type` VALUES ('7', '理学', null);
INSERT INTO `type` VALUES ('8', '工学', null);
INSERT INTO `type` VALUES ('9', '农学', null);
INSERT INTO `type` VALUES ('10', '医学', null);
INSERT INTO `type` VALUES ('11', '军事学', null);
INSERT INTO `type` VALUES ('12', '管理学', null);
INSERT INTO `type` VALUES ('13', '艺术学', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `identity_id` int(11) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `mailbox` varchar(20) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', '2', '0192023a7bbd73250516f069df18b500', '123@qq.com', '0');
INSERT INTO `users` VALUES ('dd', '1', '202cb962ac59075b964b07152d234b70', '12@qq.com', '1');
