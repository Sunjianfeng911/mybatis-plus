package com.mybatisplus.demo.util;

import com.google.common.collect.Lists;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

/** 根据父节点的ID获取所有子节点 */
public class TreeBuildUtils {

  public static final String TREE_ROOT = "0";
  /** 根据父节点的ID获取所有子节点 */
  public static List<?> build(List<?> list)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

    return build(list, TREE_ROOT, "id", "pid", "children");
  }

  public static List<?> build(List<?> list, String parentId)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

    return build(list, parentId, "id", "pid", "children");
  }

  public static List<?> build(
      List<?> list, String parentId, String idName, String pidName, String childrenName)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    List<Object> returnList = Lists.newArrayList();

    for (Object obj : list) {
      if (BeanUtils.getProperty(obj, pidName) == null) {
        continue;
      }

      if (Objects.equals(BeanUtils.getProperty(obj, pidName), parentId)) {
        recursionFn(list, obj, idName, pidName, childrenName);
        returnList.add(obj);
      }
    }
    return returnList;
  }

  /** 递归列表 */
  private static void recursionFn(
      List<?> list, Object t, String idName, String pidName, String childrenName)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // 得到子节点列表
    List<?> childList = getChildList(list, t, idName, pidName);
    BeanUtils.setProperty(t, childrenName, childList);
    for (Object tChild : childList) {
      // 判断是否有子节点
      if (hasChild(list, tChild, idName, pidName)) {
        for (Object n : childList) {
          recursionFn(list, n, idName, pidName, childrenName);
        }
      }
    }
  }

  /** 得到子节点列表 */
  private static List<?> getChildList(List<?> list, Object t, String idName, String pidName)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    List<Object> tList = Lists.newArrayList();

    for (Object obj : list) {
      if (StringUtils.isEmpty(BeanUtils.getProperty(obj, pidName))) {
        continue;
      }
      if (Objects.equals(BeanUtils.getProperty(obj, pidName), BeanUtils.getProperty(t, idName))) {
        tList.add(obj);
      }
    }
    return tList;
  }

  /** 判断是否有子节点 */
  private static boolean hasChild(List<?> list, Object t, String idName, String pidName)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    return !getChildList(list, t, idName, pidName).isEmpty();
  }
}
