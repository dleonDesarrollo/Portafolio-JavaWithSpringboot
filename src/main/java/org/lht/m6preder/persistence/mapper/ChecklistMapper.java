package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Checklist;
import org.lht.m6preder.persistence.entity.Revision;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {InspectionMapper.class})
public interface ChecklistMapper {

  @Mappings({
          @Mapping(source = "idRevision", target = "checklistId"),
          @Mapping(source = "visita", target = "inspection"),
          @Mapping(source = "estadoRevision", target = "checklistStatus"),
          @Mapping(source = "detalle", target = "details")
  })
  Checklist toChecklist(Revision revision);

  List<Checklist> toChecklists(List<Revision> revisions);

  @InheritInverseConfiguration
  Revision toRevision(Checklist checklist);

}

