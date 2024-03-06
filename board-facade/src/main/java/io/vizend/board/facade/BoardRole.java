/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;
import io.vizend.accent.domain.rolemap.DramaRole;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class BoardRole {
    /* Gen by Vizend Studio v5.1.0 */
    public static final String Director = "director";
    private List<DramaRole> roles;

    public static void validate(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardRole role = JsonUtil.fromJson(json, BoardRole.class);
        role.validate();
    }

    public void validate() {
        /* Gen by Vizend Studio v5.1.0 */
        Assert.notNull(this.roles, "'roles' is required");
        List<String> requires = new ArrayList<>(List.of(Director));
    }

    private String getFeature(Class roleClass) {
        /* Gen by Vizend Studio v5.1.0 */
        String roleClassName = roleClass.getName();
        List<String> paths = Arrays.asList(roleClassName.split("\\."));
        return paths.get(paths.indexOf("feature") + 1);
    }
}
