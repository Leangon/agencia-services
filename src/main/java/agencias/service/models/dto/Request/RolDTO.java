package agencias.service.models.dto.Request;

import agencias.service.models.enums.ERol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolDTO {

    private ERol name;
}
