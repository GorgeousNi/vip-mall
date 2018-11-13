package com.vip.base;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * 本类主要是为了使用签名
 *
 * @Title:
 * @Description:
 * @Author GorgeousNi Created in 2018/4/30 下午6:13
 */
public abstract class BaseParam implements Serializable {


  public static TreeMap<String, Object> bean2TreeMap(Object obj) {
    if (obj == null) {
      return null;
    }
    TreeMap<String, Object> map = new TreeMap<String, Object>();
    try {
      BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for (PropertyDescriptor property : propertyDescriptors) {
        String key = property.getName();
        if (!key.equals("class")) {
          Method getter = property.getReadMethod();
          Object value = getter.invoke(obj);
          map.put(key, value);
        }
      }
    } catch (Exception e) {
      System.out.println("bean2Map Error " + e);
    }
    return map;
  }

  @SuppressWarnings("rawtypes")
  public String serialize() {
    TreeMap<String, Object> treeMap = bean2TreeMap(this);
    if (treeMap.containsKey("currPage")) {
      treeMap.put("pageNo", treeMap.remove("currPage"));
    }
    StringBuffer sb = new StringBuffer();
    Iterator<String> iter = treeMap.keySet().iterator();
    while (iter.hasNext()) {
      String key = (String) iter.next();
      if (treeMap.get(key) == null) {
        continue;
      }
      if (treeMap.get(key) instanceof BaseParam) {
        sb.append(((BaseParam) treeMap.get(key)).serialize()).append("&");
      } else if (treeMap.get(key) instanceof List) {
        List list = (List) treeMap.get(key);
        for (Object obj : list) {
          if (obj instanceof BaseParam) {
            sb.append(((BaseParam) obj).serialize()).append("&");
          } else {
            sb.append(key).append("=").append(String.valueOf(obj)).append("&");
          }
        }
      } else if (treeMap.get(key).getClass().isArray()) {
        Object[] arrays = (Object[]) treeMap.get(key);
        for (Object obj : arrays) {
          if (obj instanceof BaseParam) {
            sb.append(((BaseParam) obj).serialize()).append("&");
          } else {
            sb.append(key).append("=").append(String.valueOf(obj)).append("&");
          }
        }
      } else {
        if (treeMap.get(key) instanceof Date) {
          sb.append(key).append("=").append(sdf.format(treeMap.get(key))).append("&");
        } else {
          sb.append(key).append("=").append(treeMap.get(key)).append("&");
        }
      }
    }
    return sb.deleteCharAt(sb.length() - 1).toString();
  }

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

}
