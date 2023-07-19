package net.lirent.ms.issuetracker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.lirent.ms.issuetracker.model.dto.IssueRest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("/v1")
@Tag(name = "IssueControllerApiV1", description = "Issues Rest API")
public interface IssueControllerApiV1 {

    /**
     * POST: /v1/issue: Create a new Issue
     *
     * @param issueRest Issue request
     * @return Requested Issue on success,
     * 400 on validation errors,
     * 500 on server errors.
     */
    @Operation(
            operationId = "createNewIssue",
            summary = "Create a new Issue",
            tags = {"IssueControllerApiV1"},
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful Operation"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error Validation",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content
                    )
            }
    )
    @PostMapping(
            value = "/issues",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<IssueRest> createNewIssue(
            @Parameter(
                    name = "issueRest",
                    description = "Issue rest request",
                    required = true)
            @RequestBody
            IssueRest issueRest
    );

    /**
     * GET: /v1/issues/{issueId} Find issue by id.
     *
     * @param issueId The id of the issue to get
     * @return Requested Issue on success,
     * 404 if not found any issue,
     * 500 on server errors.
     */
    @Operation(
            operationId = "findIssueById",
            summary = "Find issue by id",
            tags = {"IssueControllerApiV1"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Operation"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Issue Not Found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Server error",
                            content = @Content
                    )
            }
    )
    @GetMapping(
            value = "/issues/{issueId}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<IssueRest> findIssueById(
            @Parameter(
                    name = "issueId",
                    description = "The id of the issue to get",
                    required = true
            )
            @NotBlank
            @PathVariable
            Long issueId
    );

    /**
     * DELETE: /v1/issues/{issueId} Delete issue by id.
     *
     * @param issueId The id of the issue to delete
     * @return Requested Issue on success,
     * 404 if not found any issue,
     * 500 on server errors.
     */
    @Operation(
            operationId = "deleteIssueById",
            summary = "Delete issue by id",
            tags = {"IssueControllerApiV1"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Successful Operation"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Issue Not Found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Server error",
                            content = @Content
                    )
            }
    )
    @DeleteMapping(
            value = "/issues/{issueId}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<Void> deleteIssueById(
            @Parameter(
                    name = "issueId",
                    description = "The id of the issue to delete",
                    required = true
            )
            @NotBlank
            @PathVariable
            Long issueId
    );

    /**
     * POST: /v1/issues/ Find all Issues.
     *
     * @return All Issues on success,
     * 404 if not found any issue,
     * 500 on server errors.
     */
    @Operation(
            operationId = "findAllIssues",
            summary = "Find all issues",
            tags = {"IssueControllerApiV1"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Operation"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Issue Not Found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Server error",
                            content = @Content
                    )
            }
    )
    @GetMapping(
            value = "/issues",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<List<IssueRest>> findAllIssues();


    /**
     * PUT: /v1/issues/{issueId} Update an Issue.
     *
     * @return All Issues on success,
     * 404 if not found any issue,
     * 500 on server errors.
     */
    @Operation(
            operationId = "findAllIssues",
            summary = "Find all issues",
            tags = {"IssueControllerApiV1"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Operation"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Issue Not Found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Server error",
                            content = @Content
                    )
            }
    )
    @PutMapping(
            value = "/issues/{issueId}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<IssueRest> updateIssueById(
            @Parameter(
                    name = "issueId",
                    description = "The id of the issue to update",
                    required = true
            )
            @NotBlank
            @PathVariable
            Long issueId,
            @Parameter(
                    name = "issueRest",
                    description = "Issue rest request",
                    required = true)
            @RequestBody
            IssueRest issueRest
    );

}