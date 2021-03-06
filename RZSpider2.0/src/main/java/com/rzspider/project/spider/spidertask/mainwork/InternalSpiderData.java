package com.rzspider.project.spider.spidertask.mainwork;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.rzspider.implementspider.landmarketnetwork.domain.LMNLandMessageDetail;
import com.rzspider.project.common.spiderdata.domain.Spiderdata;
import com.rzspider.project.spider.spidertask.mainwork.domain.StartSpiderInfo;
import com.rzspider.project.spider.spidertask.mainwork.utils.InternalSpiderDataUtils;

/**
 * 具体数据解析
 * 
 * @author ricozhou
 */
@Component("internalSpiderData")
public class InternalSpiderData {
	// 需要两个参数，一个是封装信息的，一个是封装数据的
	public XSSFWorkbook analyzeInternalSpiderData_10002(StartSpiderInfo startSpiderInfo, List<Spiderdata> list) {
		if (list == null || list.size() < 1) {
			return null;
		}
		// 先解析json成对象，然后在处理
		List<LMNLandMessageDetail> lmnlmList = InternalSpiderDataUtils.jsonStringListToObjectList(list,
				new LMNLandMessageDetail());

		String[] title = { "序号", "编号", "公告名称", "公告地块编号", "公告编号", "挂牌起始时间", "挂牌截止时间", "报名开始时间", "报名截止时间", "保证金交纳开始时间",
				"保证金到账截止时间", "土地权属单位", "交易方式", "地块名称", "土地位置", "竞价规则", "所属行政区", "出让面积（平方米）", "建筑面积（平方米）", "规划用途",
				"出让年限（年）", "竞买保证金（万元）", "起始价", "竞价幅度", "出价方式", "出价单位", "特定竞价方式", "最高限价", "容积率", "绿化率", "建筑密度",
				"建筑限高（米）", "办公与服务设施用地比例（%）", "投资强度", "建设内容", "公告链接" };
		// 创建Excel工作
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建一个sheet表
		XSSFSheet sheet = workbook.createSheet();
		// 设置列宽
		sheet.setColumnWidth(2, 80 * 256);
		sheet.setColumnWidth(3, 15 * 256);
		sheet.setColumnWidth(4, 30 * 256);
		sheet.setColumnWidth(5, 25 * 256);
		sheet.setColumnWidth(6, 25 * 256);
		sheet.setColumnWidth(7, 25 * 256);
		sheet.setColumnWidth(8, 25 * 256);
		sheet.setColumnWidth(9, 25 * 256);
		sheet.setColumnWidth(10, 25 * 256);
		sheet.setColumnWidth(11, 25 * 256);
		sheet.setColumnWidth(12, 10 * 256);
		sheet.setColumnWidth(13, 30 * 256);
		sheet.setColumnWidth(14, 30 * 256);
		sheet.setColumnWidth(15, 10 * 256);
		sheet.setColumnWidth(16, 15 * 256);
		sheet.setColumnWidth(17, 10 * 256);
		sheet.setColumnWidth(18, 10 * 256);
		sheet.setColumnWidth(19, 10 * 256);
		sheet.setColumnWidth(20, 10 * 256);
		sheet.setColumnWidth(21, 10 * 256);
		sheet.setColumnWidth(22, 20 * 256);
		sheet.setColumnWidth(23, 15 * 256);
		sheet.setColumnWidth(24, 15 * 256);
		sheet.setColumnWidth(25, 15 * 256);
		sheet.setColumnWidth(26, 10 * 256);
		sheet.setColumnWidth(27, 10 * 256);
		sheet.setColumnWidth(28, 20 * 256);
		sheet.setColumnWidth(29, 15 * 256);
		sheet.setColumnWidth(30, 15 * 256);
		sheet.setColumnWidth(31, 15 * 256);
		sheet.setColumnWidth(32, 10 * 256);
		sheet.setColumnWidth(33, 10 * 256);
		sheet.setColumnWidth(34, 10 * 256);
		sheet.setColumnWidth(35, 80 * 256);

		// 创建第一行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;
		// 插入第一行数据
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		// 追加数据,向第二行开始加入数据 i = 1
		for (int i = 1; i < lmnlmList.size() + 1; i++) {
			XSSFRow row2 = sheet.createRow(i);
			XSSFCell cell2 = row2.createCell(0);
			cell2.setCellValue(i);
			cell2 = row2.createCell(1);
			cell2.setCellValue(lmnlmList.get(i - 1).getId());
			cell2 = row2.createCell(2);
			cell2.setCellValue(lmnlmList.get(i - 1).getNoticeName());
			cell2 = row2.createCell(3);
			cell2.setCellValue(lmnlmList.get(i - 1).getParcelNum());
			cell2 = row2.createCell(4);
			cell2.setCellValue(lmnlmList.get(i - 1).getAfficheNum());
			cell2 = row2.createCell(5);
			cell2.setCellValue(lmnlmList.get(i - 1).getBidStartTime());
			cell2 = row2.createCell(6);
			cell2.setCellValue(lmnlmList.get(i - 1).getBidEndTime());
			cell2 = row2.createCell(7);
			cell2.setCellValue(lmnlmList.get(i - 1).getSignStartTime());
			cell2 = row2.createCell(8);
			cell2.setCellValue(lmnlmList.get(i - 1).getSignEndTime());
			cell2 = row2.createCell(9);
			cell2.setCellValue(lmnlmList.get(i - 1).getPaymentStartTime());
			cell2 = row2.createCell(10);
			cell2.setCellValue(lmnlmList.get(i - 1).getPaymentEndTime());
			cell2 = row2.createCell(11);
			cell2.setCellValue(lmnlmList.get(i - 1).getRemiseUnit());
			cell2 = row2.createCell(12);
			cell2.setCellValue(lmnlmList.get(i - 1).getRemiseType());
			cell2 = row2.createCell(13);
			cell2.setCellValue(lmnlmList.get(i - 1).getParcelName());
			cell2 = row2.createCell(14);
			cell2.setCellValue(lmnlmList.get(i - 1).getLandPosition());
			cell2 = row2.createCell(15);
			cell2.setCellValue(lmnlmList.get(i - 1).getBidRules());
			cell2 = row2.createCell(16);
			cell2.setCellValue(lmnlmList.get(i - 1).getXzqDm());
			cell2 = row2.createCell(17);
			cell2.setCellValue(lmnlmList.get(i - 1).getRemiseArea());
			cell2 = row2.createCell(18);
			cell2.setCellValue(lmnlmList.get(i - 1).getConstructArea());
			cell2 = row2.createCell(19);
			cell2.setCellValue(lmnlmList.get(i - 1).getLandUse());
			cell2 = row2.createCell(20);
			cell2.setCellValue(lmnlmList.get(i - 1).getUseYear());
			cell2 = row2.createCell(21);
			cell2.setCellValue(lmnlmList.get(i - 1).getBail());
			cell2 = row2.createCell(22);
			cell2.setCellValue(lmnlmList.get(i - 1).getStartPrice());
			cell2 = row2.createCell(23);
			cell2.setCellValue(lmnlmList.get(i - 1).getBidScope());
			cell2 = row2.createCell(24);
			cell2.setCellValue(lmnlmList.get(i - 1).getCjfs());
			cell2 = row2.createCell(25);
			cell2.setCellValue(lmnlmList.get(i - 1).getCjdw());
			cell2 = row2.createCell(26);
			cell2.setCellValue(lmnlmList.get(i - 1).getCrxzfs());
			cell2 = row2.createCell(27);
			cell2.setCellValue(lmnlmList.get(i - 1).getZgxj());
			cell2 = row2.createCell(28);
			cell2.setCellValue(lmnlmList.get(i - 1).getRjl());
			cell2 = row2.createCell(29);
			cell2.setCellValue(lmnlmList.get(i - 1).getLhl());
			cell2 = row2.createCell(30);
			cell2.setCellValue(lmnlmList.get(i - 1).getJzmd());
			cell2 = row2.createCell(31);
			cell2.setCellValue(lmnlmList.get(i - 1).getJzxg());
			cell2 = row2.createCell(32);
			cell2.setCellValue(lmnlmList.get(i - 1).getSharePercent());
			cell2 = row2.createCell(33);
			cell2.setCellValue(lmnlmList.get(i - 1).getLowestInvest());
			cell2 = row2.createCell(34);
			cell2.setCellValue(lmnlmList.get(i - 1).getBuildMatter());
			cell2 = row2.createCell(35);
			cell2.setCellValue(lmnlmList.get(i - 1).getNoticeLink());
		}

		// 写入文件
		return workbook;
	}

}
