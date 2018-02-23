package com.kuangcp.mythpoi.excel.base;

/**
 * Created by https://github.com/kuangcp on 18-2-23  上午11:09
 * 声明该接口是做到了对象和Excel的转换
 * @author kuangcp
 */
public interface ExcelTransform {

    /**
     * 获取Excel需要导出的标题
     */
    String getExcelExportTitle();
    String getExcelImportTitle();
}
