/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board;

import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.facade.BoardRole;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BoardSchemeResource {
    /* Gen by Vizend Studio v5.1.0 */
    private final Map<String, Object> scheme;

    public BoardSchemeResource(@Value("classpath:drama.json") Resource resourceFile) throws IOException {
        /* Gen by Vizend Studio v5.1.0 */
        String json = new String(resourceFile.getInputStream().readAllBytes());
        BoardRole.validate(json);
        this.scheme = JsonUtil.fromJson(json, Map.class);
    }

    @GetMapping("/scheme")
    public Map<String, Object> scheme() {
        /* Gen by Vizend Studio v5.1.0 */
        return this.scheme;
    }
}
