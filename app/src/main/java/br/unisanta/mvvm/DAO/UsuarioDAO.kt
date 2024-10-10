package br.unisanta.mvvm.DAO

import br.unisanta.mvvm.model.Usuario

class UsuarioDAO {
    companion object {

        private val usuarios = mutableListOf<Usuario>()

        init {

            val usuarioAdmin = Usuario(email = "ivansolfire@gmail.com", senha = "1234")
            usuarios.add(usuarioAdmin)
        }


        fun adicionarUsuario(usuario: Usuario): String {
            if (usuarios.any { it.email == usuario.email }) {
                return "Usuário já cadastrado."
            }
            usuarios.add(usuario.copy(tentativas = 0, bloqueado = false))
            return "Cadastrado com sucesso."
        }


        fun listarUsuarios(): List<Usuario> {
            return usuarios.toList()
        }


        fun encontrarUsuario(email: String): Usuario? {
            return usuarios.find { it.email == email }
        }
    }
}