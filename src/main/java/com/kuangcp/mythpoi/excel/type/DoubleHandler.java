package com.kuangcp.mythpoi.excel.type;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 * Created by https://github.com/kuangcp on 18-3-12  下午7:24
 *
 * @author kuangcp
 */
public class DoubleHandler implements LoadCellValue {
    @Override
    public HSSFCell loadValue(HSSFRow row, int index, Object value) {
        HSSFCell cell = row.createCell(index, HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(Double.valueOf(value.toString()));
        return cell;
    }
}
