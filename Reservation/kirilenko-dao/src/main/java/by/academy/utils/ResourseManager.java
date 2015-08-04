package by.academy.utils;

import java.util.ResourceBundle;

public enum ResourseManager {

	CONNECTION {
		@Override
		public String getKey(String key) {
			return ResourceBundle.getBundle("db").getString(key);
		}
	},
	SQL {
		@Override
		public String getKey(String key) {
			return ResourceBundle.getBundle("sql").getString(key);
		}
	};

	public abstract String getKey(String key);

}
