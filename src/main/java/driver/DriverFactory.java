package driver;

public enum DriverFactory {

	CHROME {
		@Override
		public DriverManager getDriverManager() {
			return new ChromeDriverManager();
		}

	},

	FIREFOX {
		@Override
		public DriverManager getDriverManager() {
			return new FirefoxDriverManager();
		}

	},

	IE {
		@Override
		public DriverManager getDriverManager() {
			return new IEDriverManager();
		}

	},

	SAFARI {
		@Override
		public DriverManager getDriverManager() {
			return new SafariDriverManager();
		}

	},

	EDGE {
		@Override
		public DriverManager getDriverManager() { return new EdgeDriverManager(); }
	};
	
	public abstract DriverManager getDriverManager();
}
