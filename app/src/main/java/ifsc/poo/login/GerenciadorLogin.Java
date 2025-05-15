package ifsc.poo.login;

public class GerenciadorLogin {
    private static final Map<String, String> usuarios = new HashMap<>();
    
    public static boolean cadastrar(String login, String senha){
        String LoginKey = login.toLowerCase();
        if(usuarios.containsKey(LoginKey)) return false;
        usuarios.put(LoginKey, senha);
        return true; 
    }

    public static boolean remover(String login){
        String LoginKey = login.toLowerCase();
        if(!usuarios.containsKey(LoginKey)) return false;
        usuarios.remove(LoginKey);
        return true; 
    }

    public static List<String> listar(){
        List<String> lista = new ArrayList<>();
        for(String login : usuarios.keySet()){
            lista.add(login);
        }
        return lista;
    }

    public static boolean autenticar(String login, String senha){
        String LoginKey = login.toLowerCase();
        if(!usuarios.containsKey(LoginKey)) return false;
        return usuarios.get(LoginKey).equals(senha);
    }
}

