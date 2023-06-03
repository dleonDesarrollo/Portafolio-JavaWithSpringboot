package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.persistence.entity.Cliente;
import org.lht.m6preder.persistence.entity.SistemaSalud;
import org.lht.m6preder.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CustomerMapper {

  @Mappings({
          @Mapping(source = "idCliente", target = "customerId"),
          @Mapping(source = "usuario", target = "user"),
          @Mapping(source = "rut", target = "str"),
//          @Mapping(source = "nombres", target = "firstName"),
//          @Mapping(source = "apellidos", target = "lastName"),
          @Mapping(source = "telefono", target = "phoneNumber"),
          @Mapping(source = "afp", target = "pfa"),
          @Mapping(source = "sistemaSalud", target = "healthSystem"),
          @Mapping(source = "direccion", target = "address"),
          @Mapping(source = "comuna", target = "district"),
          @Mapping(source = "edad", target = "age"),

  })
  Customer toCustomer(Cliente cliente);

  List<Customer> toCustomers(List<Cliente> clientes);

  @InheritInverseConfiguration
  Cliente toCliente(Customer customer);

}
