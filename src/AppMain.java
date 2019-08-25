public class AppMain {

    public static void main(String[] args) {
        ProcessHandle.allProcesses().forEach(AppMain::checkProcess);
    }
    public static void checkProcess(ProcessHandle handle) {
        String cmd;
        if(handle.info().commandLine().isPresent()) {
            cmd = handle.info().commandLine().get();
            if(cmd.trim().toLowerCase().contains("leagueoflegends") ||
                cmd.trim().toLowerCase().contains("riotgames"))
                handle.destroy();
        }
    }
}
