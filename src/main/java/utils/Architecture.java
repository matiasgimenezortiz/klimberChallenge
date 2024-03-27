package utils;

public class Architecture {

	public static boolean is64bits() {
		boolean is64bit = false;
		if (System.getProperty("os.name").contains("Windows")) {
			is64bit = System.getenv("ProgramFiles(x86)") != null;
		} else {
			is64bit = System.getProperty("os.arch").contains("64");
		}

		return is64bit;
	}

}
