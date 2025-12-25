package com.p94.usuario.business.converter;

import com.p94.usuario.business.dto.EnderecoDTO;
import com.p94.usuario.business.dto.TelefoneDTO;
import com.p94.usuario.business.dto.UsuarioDTO;
import com.p94.usuario.infrastructure.entity.Endereco;
import com.p94.usuario.infrastructure.entity.Telefone;
import com.p94.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEndereco()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefone()))
                .build();
    }

    public List<Endereco> paraListaEndereco (List<EnderecoDTO> enderecoDTO){
        return enderecoDTO.stream().map(this::paraEndereco).toList();
    }

    public List<Telefone> paraListaTelefone (List<TelefoneDTO> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefone).toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .endereco(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefone(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO (List<Endereco> endereco){
        return endereco.stream().map(this::paraEnderecoDTO).toList();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO (List<Telefone> telefone) {
        return telefone.stream().map(this::paraTelefoneDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }
}
